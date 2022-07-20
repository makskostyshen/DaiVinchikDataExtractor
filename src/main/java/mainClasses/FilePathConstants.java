package mainClasses;

public class FilePathConstants {

    private static final String folderPath =
            "C:\\Users\\maxxx\\Desktop\\DS_fundamentals\\DaiVinchikProject\\Maks_Kostyshen";

    private static final String jsonFileName
            = "result3.json";

    public static String getJsonFilePath(){
        return folderPath + "//" + jsonFileName;
    }

    public static String getFullPathFromPartial(String partialPath){
        return folderPath + "//" + partialPath;
    }

    public static String getFolderName(){                       ///////////////need to be changed
        return "maks_kostyshen";
    }
}
