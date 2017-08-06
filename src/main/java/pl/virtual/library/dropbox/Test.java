package pl.virtual.library.dropbox;

import pl.virtual.library.dropbox.ports.dropbox.DropboxOperation;
import pl.virtual.library.dropbox.ports.dropbox.mapper.EbooksListMapper;

public class Test
{
    public static void main(String args[]){
        DropboxOperation operation = new DropboxOperation();
        System.out.println(operation.getEbookMetadata());

        EbooksListMapper mapper = new EbooksListMapper();
        mapper.mapToEbooksList(operation.getEbookMetadata());

    }
}
