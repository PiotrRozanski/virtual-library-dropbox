package pl.virtual.library.dropbox.ports.dropbox.mapper;

import com.dropbox.core.v2.files.ListFolderResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import pl.virtual.library.dropbox.application.command.Ebook;
import pl.virtual.library.dropbox.ports.dropbox.mapper.exception.EbooksListException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class EbooksListMapper {

    public List<Ebook> mapToEbooksList(final ListFolderResult listFolderResult) {
        final JSONArray ebooksListJson = prepareJsonArrayOfEbooks(listFolderResult);
        final Type listType = new TypeToken<List<Ebook>>() {}.getType();
        
        return normalizeEbookName(new Gson().fromJson(ebooksListJson.toString(), listType));
     }

    private JSONArray prepareJsonArrayOfEbooks(final ListFolderResult listFolderResult) {
        try {
            final JSONObject json = new JSONObject(listFolderResult);
            return json.getJSONArray("entries");
        } catch (JSONException e) {
            throw new EbooksListException("Bad formatted json");
        }
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
