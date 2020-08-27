package AndrDaniel.com.github;

import AndrDaniel.com.github.exceptions.PersistenceToFileException;
import AndrDaniel.com.github.ui.tex.TextUI;
import AndrDaniel.com.github.util.Properties;

import java.io.IOException;




    public class App {
        private static final TextUI textUI = new TextUI();
        public static void main(String[] args) {
            try {
                Properties.createDataDirectory();
            } catch (IOException e) {
                throw new PersistenceToFileException(Properties.DATA_DIRECTORY.toString(), "create", "directory");
            }
            textUI.showSystemInfo();
            textUI.showMainMenu();
        }
    }

