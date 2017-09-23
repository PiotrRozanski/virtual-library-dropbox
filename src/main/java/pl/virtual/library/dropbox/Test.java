package pl.virtual.library.dropbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test
{
//    public static void main(String args[]){
//        DropboxOperation operation = new DropboxOperation();
//        System.out.println(operation.getEbookMetadata().toStringMultiline());
//
//        EbooksListMapper mapper = new EbooksListMapper();
//        mapper.mapToEbooksList(operation.getEbookMetadata());
//        System.out.println(mapper.mapToEbooksList(operation.getEbookMetadata()));
//    }

    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }
}
