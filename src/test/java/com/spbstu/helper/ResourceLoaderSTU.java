package com.spbstu.helper;

import com.google.gson.Gson;
import com.mifmif.common.regex.Generex;
import com.spbstu.pageObjets.entities.Issue;
import com.spbstu.pageObjets.entities.User;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * Created by germanium on 30.05.17.
 */
public class ResourceLoaderSTU {

    private static final String DATA_USERS_JSON = "data/users.json";
    private static final String DATA_ISSUES_JSON = "data/issues.json";

    public static Map<String, User> users;
    public static Issue issue;

    static {
        try {
            loadUsers();
            loadIssue();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @SneakyThrows
    private static void loadIssue() throws IOException {
        String rawData = getRawData(DATA_ISSUES_JSON);
        issue = new Gson().fromJson(rawData, new com.google.common.reflect.TypeToken<Issue>(){}.getType());
        issue.setSummary(new Generex(issue.getSummary()).random());
        issue.setDescription(new Generex(issue.getDescription()).random());
        issue.setStepsToReproduce(new Generex(issue.getStepsToReproduce()).random());
        issue.setAdditionalInformation(new Generex(issue.getAdditionalInformation()).random());

    }

    @SneakyThrows
    private static void loadUsers() throws IOException {
        String rawData = getRawData(DATA_USERS_JSON);
        users = new Gson().fromJson(rawData, new com.google.common.reflect.TypeToken<Map<String, User>>(){}.getType());
    }

    private static String getRawData(String dataUserJson) throws IOException {
        URL resource = ResourceLoaderSTU.class.getClassLoader().getResource(dataUserJson);
        return IOUtils.toString(resource, "utf-8");
    }

    public static Issue getIssue(){
        return issue;
    }

}


