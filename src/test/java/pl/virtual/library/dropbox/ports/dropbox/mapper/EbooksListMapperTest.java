package pl.virtual.library.dropbox.ports.dropbox.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.virtual.library.dropbox.application.command.Ebook;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EbooksListMapperTest {
    private Ebook ebook_1 = new Ebook("Programista samouk", "1", "10", "/Programista samouk.pdf");
    private Ebook ebook_2 = new Ebook("Programista", "2", "3", "/Programista.pdf");
    private Ebook ebook_3 = new Ebook("Testowanie", "3", "5", "/Testowanie.pdf");
    private List<Ebook> ebookListResult = new ArrayList<>();
    private List<Ebook> listJsonResult;

    @Before
    public void addEbooks() {
        final String JSON =
            "[{\n" +
                "\t\"entries\": [\n" +
                "\t\t{\n" +
                "\t\t\t\".tag\": \"file\",\n" +
                "\t\t\t\"name\": \"Programista samouk.pdf\",\n" +
                "\t\t\t\"id\": \"1\",\n" +
                "\t\t\t\"client_modified\": \"2017-09-17T08:05:54Z\",\n" +
                "\t\t\t\"server_modified\": \"2017-09-17T08:17:45Z\",\n" +
                "\t\t\t\"rev\": \"75a49070b\",\n" +
                "\t\t\t\"size\": 10,\n" +
                "\t\t\t\"path_lower\": \"/Programista samouk.pdf\",\n" +
                "\t\t\t\"path_display\": \"/Spring Microservices in Action - John Carnell.pdf\",\n" +
                "\t\t\t\"content_hash\": \"e351a76d5c08950d4437949fec692d2b9721a9daaecb5dbfd617cf54955afe1a\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\".tag\": \"file\",\n" +
                "\t\t\t\"name\": \"Programista.pdf\",\n" +
                "\t\t\t\"id\": \"2\",\n" +
                "\t\t\t\"client_modified\": \"2017-09-17T08:05:31Z\",\n" +
                "\t\t\t\"server_modified\": \"2017-11-03T10:52:22Z\",\n" +
                "\t\t\t\"rev\": \"a5a49070b\",\n" +
                "\t\t\t\"size\": 3,\n" +
                "\t\t\t\"path_lower\": \"/Programista.pdf\",\n" +
                "\t\t\t\"path_display\": \"/Core Java for the Impatient.pdf\",\n" +
                "\t\t\t\"content_hash\": \"a0a76a9edef194caedcfe95e46fa8b4fd7c7b87bcb8164f7c5b2f042b08bd1ed\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\".tag\": \"file\",\n" +
                "\t\t\t\"name\": \"Testowanie.pdf\",\n" +
                "\t\t\t\"id\": \"3\",\n" +
                "\t\t\t\"client_modified\": \"2017-09-17T08:06:01Z\",\n" +
                "\t\t\t\"server_modified\": \"2017-11-03T10:52:53Z\",\n" +
                "\t\t\t\"rev\": \"c5a49070b\",\n" +
                "\t\t\t\"size\": 5,\n" +
                "\t\t\t\"path_lower\": \"/Testowanie.pdf\",\n" +
                "\t\t\t\"path_display\": \"/Mastering Microservices with Java.pdf\",\n" +
                "\t\t\t\"content_hash\": \"d60912a1f1853e2b7b8c69f507f205ff45e0482d1cf3d4ca68f74052db95bd0d\"\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"cursor\": \"AAHvpepXZ9iN7bERXOGs8KnnopY1RMRacDAQ9tt5oT4OLC629lIK2HaNeA0llxKs9dJklDOTWOtUb3uaZDhPARts2KJeb571Ex6Pgjim32Lz1okFWYuXqg9XcCisoitOdnMID_50XSpKaPxoWvX3vlgp\",\n" +
                "\t\"has_more\": false\n" +
                "}]";

        ebookListResult.add(ebook_1);
        ebookListResult.add(ebook_2);
        ebookListResult.add(ebook_3);

        final JSONArray ebookListTestJson;
        try {
            ebookListTestJson = new JSONArray(JSON);
            final Type listType = new TypeToken<List<Ebook>>() {}.getType();
            listJsonResult = normalizeEbookName(new Gson().fromJson(ebookListTestJson.getJSONObject(0).getString("entries"), listType));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void chceckNameEbooksFromDropboxJSON() {
            Assert.assertEquals(listJsonResult.get(0).getName(), ebookListResult.get(0).getName());
    }

    @Test
    public void chceckIDEbooksFromDropboxJSON() {
        Assert.assertEquals(listJsonResult.get(0).getId(), ebookListResult.get(0).getId());
    }

    @Test
    public void chceckSizeEbooksFromDropboxJSON() {
        Assert.assertEquals(listJsonResult.get(0).getSize(), ebookListResult.get(0).getSize());
    }

    @Test
    public void chceckPathLowerEbooksFromDropboxJSON() {
        Assert.assertEquals(listJsonResult.get(0).getPathLower(), ebookListResult.get(0).getPathLower());
    }

    @Test
    public void mapToEbooksListTest() {
        Assert.assertEquals(listJsonResult.toString(),ebookListResult.toString());
    }

    @Test
    public void checkCountEbooksInLIstFromDropboxJSON() {
        Assert.assertEquals(listJsonResult.size(),3);
    }


    private List<Ebook> normalizeEbookName(final List<Ebook> ebooks) {
        final List<Ebook> correctedEbooks = new ArrayList<>();
        for (final Ebook ebook:ebooks) {
            final String name = StringUtils.substringBefore(ebook.getName(), ".");
            ebook.setName(name);
            correctedEbooks.add(ebook);
        }
        return correctedEbooks;
    }
}
