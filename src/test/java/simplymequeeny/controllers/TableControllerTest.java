package simplymequeeny.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import simplymequeeny.AbstractBaseTest;
import simplymequeeny.dynamodb.AwsDbClient;

import java.util.Collections;

@SpringBootTest
public class TableControllerTest extends AbstractBaseTest {

    @Autowired
    private TableController controller;

    @Test
    public void shouldReturnEmptyTableNamesExceptionOccurred() {
        Assert.assertEquals(Collections.EMPTY_LIST, controller.names());
    }

    @Test
    public void shouldReturnNonNullTableDescriptionExceptionOccurred() {
        Assert.assertNotNull(controller.definition("table"));
    }

    @Test
    public void shouldReturEmptyItemListExceptionOccurred() {
        Assert.assertNotNull(controller.items("table"));
    }

    @Test
    public void shouldReturAwsConnectionType() {
        Assert.assertEquals(AwsDbClient.ConnectionType.AWS, controller.connectionType());
    }
}
