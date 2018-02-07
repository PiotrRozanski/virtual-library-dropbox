package pl.virtual.library.dropbox.ports.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.virtual.library.dropbox.ports.rest.request.EbookCommand;
import pl.virtual.library.dropbox.ports.service.DropboxService;

import java.io.FileOutputStream;
import java.io.OutputStream;


@RestController
@RequestMapping("/dropbox")
@Api(value = "Dropbox", description = "The operations getting an e-books from the dropbox service")
public class DropboxFilesController {

    private final Logger logger;
    private final DropboxService dropboxService;

    public DropboxFilesController(final DropboxService dropboxService) {
        this.logger = LoggerFactory.getLogger(DropboxFilesController.class);
        this.dropboxService = dropboxService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/download/ebooks", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved all ebooks from dropbox"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseBody
    public void getAllEBooks() {
        dropboxService.downloadAllEbooks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/download/ebook", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully downloaded ebook"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public void downloadEbook(@RequestBody final EbookCommand command) {
        dropboxService.downloadEbook(command.getPath());
    }

    //ToDo poprawić sposób wyświetlania błedów przy ich wyłapywaniu
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void dropboxException(final Exception e) {
        logger.error("Exception handler executed" + e);
    }

}
