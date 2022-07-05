package Additional;

public class PATH_CONSTANTS {
    private static final String folderPath =
            "C:\\Users\\maxxx\\Desktop\\DS_fundamentals\\DaiVinchikProject\\Maks_Kostyshen";

    private static final String jsonFileName
            = "result2.json";

    public static final String getJsonFilePath(){
        return folderPath + "//" + jsonFileName;
    }

    public static final String getFolderPath(){
        return folderPath;
    }

    public static final String getFullPathFromPartial(String partialPath){
        return folderPath + "//" + partialPath;
    }
}
