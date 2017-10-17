package pl.virtual.library.dropbox.ports.rest.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Ebook")
public class EbookCommand {

    @ApiModelProperty(value = "The path of the ebook", required = true)
    private String path;

    public String getPath() {
        return path;
    }
}
