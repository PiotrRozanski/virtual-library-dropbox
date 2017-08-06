package pl.virtual.library.dropbox.ports.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.virtual.library.dropbox.ports.service.DropboxService;

@RestController
@RequestMapping("/dropbox")
@ComponentScan({"pl.virtual.library.dropbox.ports"})
@Api(value = "Dropbox", description = "The operations getting an e-books from the dropbox service")
public class DropboxFilesController {

    private DropboxService dropboxService;

    public DropboxFilesController(final DropboxService dropboxService) {
        this.dropboxService = dropboxService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/download/ebooks", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved all ebooks from dropbox"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseBody
    private void getAllEBooks() {
        dropboxService.saveAllEbooks();
    }
}
