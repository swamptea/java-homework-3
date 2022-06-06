import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    static StringBuilder log = new StringBuilder();
    static String done = "успешно\n";
    static String error = "при создании произошла ошибка\n";

    static void createFile(File file, boolean dir) throws IOException {
        String type = (dir ? "директории " : "файла ");
        log.append(new Date() + " создание " + type + file.getName() + "... ");
        if (dir ? file.mkdir() : file.createNewFile())
            log.append(done);
        else log.append(error);
    }

    public static void main(String[] args) {

        File src, res, savegames, temp, main, test, drawables, vectors, icons,
                mainJava, utilsJava, tempTxt;

        List<File> dirs = new ArrayList<>();
        List<File> files = new ArrayList<>();
        dirs.add(src = new File("/home/alexandra/Games/src"));
        dirs.add(res = new File("/home/alexandra/Games/res"));
        dirs.add(savegames = new File("/home/alexandra/Games/savegames"));
        dirs.add(temp = new File("/home/alexandra/Games/temp"));
        dirs.add(main = new File("/home/alexandra/Games/src/main"));
        dirs.add(test = new File("/home/alexandra/Games/src/test"));
        dirs.add(drawables = new File("/home/alexandra/Games/res/drawables"));
        dirs.add(vectors = new File("/home/alexandra/Games/res/vectors"));
        dirs.add(icons = new File("/home/alexandra/Games/res/icons"));
        files.add(mainJava = new File("/home/alexandra/Games/src/main/Main.java"));
        files.add(utilsJava = new File("/home/alexandra/Games/src/main/Utils.java"));
        files.add(tempTxt = new File("/home/alexandra/Games/temp/temp.txt"));

        for (File dir : dirs) {
            try {
                createFile(dir, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (File file : files) {
            try {
                createFile(file, false);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
