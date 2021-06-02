import java.nio.file.*;
import java.nio.file.attribute.*;

public class qwerty {
    public static void main(String[] args) {
        changeOwnerShip("/home/arpit/Desktop/a.txt");
    }

    public static boolean changeOwnerShip(String parts) {
        try
        {
            Path path = Paths.get(parts);

            FileOwnerAttributeView foav = Files.getFileAttributeView(path,
                    FileOwnerAttributeView.class);

            FileSystem fs = FileSystems.getDefault();

            UserPrincipalLookupService upls = fs.getUserPrincipalLookupService();

            UserPrincipal newOwner = upls.lookupPrincipalByName("clickhouse");

            foav.setOwner(newOwner);

            GroupPrincipal group = upls.lookupPrincipalByGroupName("clickhouse");

            Files.getFileAttributeView(path, PosixFileAttributeView.class, LinkOption.NOFOLLOW_LINKS).setGroup(group);

            UserPrincipal changedOwner = foav.getOwner();



            return true;
        }
        catch (Exception exception)
        {

        }



        return false;
    }
}
