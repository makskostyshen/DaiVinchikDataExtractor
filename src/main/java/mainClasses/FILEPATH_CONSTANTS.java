package mainClasses;

public class FILEPATH_CONSTANTS {

    private static final String folderPath =
            "C:\\Users\\maxxx\\Desktop\\DS_fundamentals\\DaiVinchikProject\\Maks_Kostyshen";

    private static final String jsonFileName
            = "result.json";

    public static String getJsonFilePath(){
        return folderPath + "//" + jsonFileName;
    }

    public static String getFolderPath(){
        return folderPath;
    }

    public static String getFullPathFromPartial(String partialPath){
        return folderPath + "//" + partialPath;
    }
}
