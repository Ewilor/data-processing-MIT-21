package com.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.model.Literature;
import com.utils.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LiteratureService {
    private static final String FILE_PATH = "/relative-path";
    private List<Literature> literatureList;

    public LiteratureService() {
        literatureList = loadLiteratureList();
    }

    public List<Literature> getAllLiteratureList() {
        return literatureList;
    }

    public void addLiterature(Literature literature) {
        int newId = literatureList.isEmpty() ? 1 : literatureList.get(literatureList.size() - 1).getId() + 1;
        literature.setId(newId);
        literatureList.add(literature);
        saveLiteratureList();
    }

    public boolean updatedLiterature(Literature updatedLiterature) {
        for (int i = 0; i < literatureList.size(); i++) {
            if (literatureList.get(i).getId() == updatedLiterature.getId()) {
                literatureList.set(i, updatedLiterature);
                saveLiteratureList();
                return true;
            }
        }
        return false;
    }

    public boolean deleteLiterature(int id) {
        boolean removed = literatureList.removeIf(l -> l.getId() == id);
        if (removed) saveLiteratureList();
        return removed;
    }

    private List<Literature> loadLiteratureList() {
        try {
            System.out.println("Читаю файл: " + FILE_PATH);
            String json = FileUtil.readFromFile(FILE_PATH);
            System.out.println("JSON з файлу: " + json);

            return new Gson().fromJson(json, new TypeToken<List<Literature>>() {}.getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void saveLiteratureList() {
        try {
            String json = new Gson().toJson(literatureList);
            FileUtil.writeToFile(FILE_PATH, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
