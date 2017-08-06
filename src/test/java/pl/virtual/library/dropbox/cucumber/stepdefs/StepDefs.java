package pl.virtual.library.dropbox.cucumber.stepdefs;

import pl.virtual.library.dropbox.VirtualLibraryDropboxApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = VirtualLibraryDropboxApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
