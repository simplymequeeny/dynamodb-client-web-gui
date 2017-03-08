var app = angular.module('dynamodb-web-gui', 
  ['ui.bootstrap', 'ui.grid', 'ui.grid.selection','angular-json-tree']);

app.controller('ModalPopup', ModalPopup);
app.controller('tables', function ($scope, $http, $uibModal) {
  var self = this;

  var currentTab;
  var currentTable;

  var describe = function (name) {
    $scope.showGrid = false;
    console.log('retrieving table definition of ' + name);
    $http.get('/describe/' + name).then(function (response) {
      console.log(response.data);
      $scope.table = response.data;
    });
  };

  var scan = function (name, filter) {
    $scope.showGrid = false;
    if (name !== undefined) {
      $scope.gridOptions = {
        enableFiltering: true,
        flatEntityAccess: false,
        enableRowSelection: true,
        enableRowHeaderSelection: false,
        showGridFooter: true,
        fastWatch: true,
        multiSelect: false,
        modifierKeysToMultiSelect: false,
        noUnselect: true,
        onRegisterApi: function (gridApi) {
          $scope.gridApi = gridApi;
        },
        appScopeProvider: {
          onDblClick: function (row) {
            console.log('row', JSON.stringify(row.entity));
            $uibModal.open({
              templateUrl: 'modal-popup.html',
              controller: ModalPopup,
              resolve: {
                row: function () {
                  return row;
                },
                table: function () {
                  return $scope.table;
                }
              }
            }).result.then(
                    function () {
                      console.log("OK");
                    },
                    function () {
                      console.log("Cancel");
                    }
            );
          }
        },
        rowTemplate: "<div ng-dblclick=\"grid.appScope.onDblClick(row)\" " +
                "ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" " +
                "class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell >" +
                "</div>"
      };

      $http.get('/scan/' + name + '/items').then(function (response) {
        console.log('scanned items', response.data);
        $scope.gridOptions.data = response.data;
        $scope.showGrid = true;
      });
    }
  };

  var tab = function (tab) {
    var selected = tab === currentTab;
    return selected;
  };

  var fetchData = function() {
    console.log('fetching ...', currentTab);
    if (tab('items') && $scope.isLocal) scan(currentTable);
    else describe(currentTable);
  };

  $scope.selectedTab = function (tab) {
    currentTab = tab;
    fetchData();
  };

  $scope.selectedTable = function(table) {
    currentTable = table;
    fetchData();
  };

  $scope.showGrid = false;
  $scope.tab = tab;

  $scope.tbl = function (table) {
    var selected = table === currentTable;
    return selected;
  };

  $scope.fetchItems = function() {
    scan(currentTable);
  };

  $scope.init = function () {
    console.log('initializing ...');
    $http.get('/connection-type').then(function(response) {
      console.log('connection type', response.data);
      $scope.isLocal = response.data === 'LOCAL';

       $http.get('/names').then(function (response) {
        console.log(response.data);
        $scope.names = response.data;

        currentTab = 'items';
        currentTable = response.data[0];

        console.log('is local?', $scope.isLocal);
        if ($scope.isLocal) scan(currentTable);
       });
    });
  };

  $scope.init();
});

var ModalPopup = function ($scope, $uibModalInstance, row, table) {
  $scope.ok = function () {
    $uibModalInstance.close();
  };
  $scope.row = row;
  $scope.table = table;
  $scope.cancel = function () {
    $uibModalInstance.dismiss('cancel');
  };
};
