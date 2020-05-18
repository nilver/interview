package service;

import delivery.exception.InputException;
import delivery.exception.SenderServiceException;
import delivery.service.FileService;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class FileServiceTest {

    private FileService fileService;

    @Before
    public void setUp(){
        fileService = new FileService();
    }

    @Test(expected = InputException.class)
    public void when_getMovements_and_NOT_name_then_SenderServiceException(){
        fileService.getMovements("INVALID_NAME");
    }

}
