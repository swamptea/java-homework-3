import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {

        File src = new File("/home/alexandra/Games/src");
        File res = new File("/home/alexandra/Games/res");
        File savegames = new File("/home/alexandra/Games/savegames");
        File temp = new File("/home/alexandra/Games/temp");
        File main = new File("/home/alexandra/Games/src/main");
        File test = new File("/home/alexandra/Games/src/test");
        File drawables = new File("/home/alexandra/Games/res/drawables");
        File vectors = new File("/home/alexandra/Games/res/vectors");
        File icons = new File("/home/alexandra/Games/res/icons");
        File mainJava = new File("/home/alexandra/Games/src/main/Main.java");
        File utilsJava = new File("/home/alexandra/Games/src/main/Utils.java");
        File tempTxt = new File("/home/alexandra/Games/temp/temp.txt");
        log.append(new Date() + " создание директории src... ");
        if (src.mkdir())
            log.append("успешно\n");
        else log.append("при создании произошла ошибка\n");
        log.append(new Date() + " создание директории res... ");
        if (res.mkdir())
            log.append("успешно\n");
        else log.append("при создании произошла ошибка\n");
        log.append(new Date() + " создание директории savegames... ");
        if (savegames.mkdir())
            log.append("успешно\n");
        else log.append("при создании произошла ошибка\n");
        log.append(new Date() + " создание директории temp... ");
        if (temp.mkdir())
            log.append("успешно\n");
        else log.append("при создании произошла ошибка\n");
        log.append(new Date() + " создание директории main... ");
        if (main.mkdir())
            log.append("успешно\n");
        else log.append("при создании произошла ошибка\n");
        log.append(new Date() + " создание директории test... ");
        if (test.mkdir())
            log.append("успешно\n");
        else log.append("при создании произошла ошибка\n");
        log.append(new Date() + " создание директории drawables... ");
        if (drawables.mkdir())
            log.append("успешно\n");
        else log.append("при создании произошла ошибка\n");
        log.append(new Date() + " создание директории vectors... ");
        if (vectors.mkdir())
            log.append("успешно\n");
        else log.append("при создании произошла ошибка\n");
        log.append(new Date() + " создание директории icons... ");
        if (icons.mkdir())
            log.append("успешно\n");
        else log.append("при создании произошла ошибка\n");
        try {
            log.append(new Date() + " создание файла Main.java... ");
            if (mainJava.createNewFile())
                log.append("успешно\n");
            else log.append("при создании произошла ошибка\n");
            log.append(new Date() + " создание файла Utils.java... ");
            if (utilsJava.createNewFile())
                log.append("успешно\n");
            else log.append("при создании произошла ошибка\n");
            log.append(new Date() + " создание файла temp.txt... ");
            if (tempTxt.createNewFile())
                log.append("успешно\n");
            else log.append("при создании произошла ошибка\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(tempTxt)) {
            writer.write(String.valueOf(log));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<GameProgress> list = new ArrayList<>();
        list.add(new GameProgress(8, 3, 3, 18.5));
        list.add(new GameProgress(44, 9, 13, 20.5));
        list.add(new GameProgress(89, 13, 30, 120.25));

        for (int i = 0; i < list.size(); i++) {
            GameProgress.saveGame(savegames.getAbsolutePath() + "/save" + i + ".dat", list.get(i));
        }

        GameProgress.zipFiles(savegames.getAbsolutePath() + "/zip.zip", savegames.listFiles());
        GameProgress.openZip(savegames.getAbsolutePath() + "/zip.zip", savegames.getAbsolutePath());
        System.out.println(GameProgress.openProgress(savegames.getAbsolutePath() + "/save2.dat"));
    }
}
