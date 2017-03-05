var app = angular.module('dynamodb-web-gui', 
  ['ui.bootstrap', 'ui.grid', 'ui.grid.selection','angular-json-tree']);

app.controller('ModalPopup', ModalPopup);
app.controller('tables', function ($scope, $http, $uibModal) {
  var self = this;
  
  $scope.showGrid = false;
  $scope.init = function () {
    console.log('initializing ...');
    $http.get('/names').then(function (response) {
      console.log(response.data);
      $scope.names = response.data;
      selectedTab('items');
      describe(response.data[0]);
    });
    
    $http.get('/connection-type').then(function(response) {
      console.log('connection type', response.data);
      $scope.isLocal = response.data === 'LOCAL';
    });
  };
  
  var currentTable;
  var describe = function (name) {
    $scope.showGrid = false;
    currentTable = name;
    console.log('retrieving table definition of ' + name);
    $http.get('/describe/' + name).then(function (response) {
      console.log(response.data);
      $scope.table = response.data;
      scan(name);
    });
  };

  $scope.tbl = function (tab) {
    var selected = tab === currentTable;
    return selected;
  };

  var currentTab;
  var selectedTab = function (tab) {
    currentTab = tab;
    if (tab === 'items')
      scan(currentTable);
  };

  $scope.tab = function (tab) {
    var selected = tab === currentTab;
    return selected;
  };

  var scan = function (name, filter) {
    $scope.showGrid = false;
    if (name !== undefined) {
      $scope.gridOptions = {
        enableFiltering: false,
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

  $scope.selectedTab = selectedTab;
  $scope.describe = describe;

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
