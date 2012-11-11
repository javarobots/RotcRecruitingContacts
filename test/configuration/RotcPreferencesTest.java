package configuration;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author javarobots <javarobots74@gmail.com>
 */
public class RotcPreferencesTest {

    private static String WORK_DIR = "C:/Program Files/RotcContacts";
    private static String SYNC_DIR = "C:/Program Files/RotcContactsSync";

    public RotcPreferencesTest() {
    }

    @Test
    public void testGetWorkDir() {
        System.out.println("getWorkDir");
        RotcPreferences instance = new RotcPreferences();
        System.out.println(instance.getWorkDir());
    }

    @Test
    public void testSetWorkDir() {
        System.out.println("setWorkDir");
        RotcPreferences instance = new RotcPreferences();
        String originalPath = instance.getWorkDir();
        instance.setWorkDir("C:/Test Path");
        Assert.assertEquals("C:/Test Path", instance.getWorkDir());
        instance.setWorkDir(originalPath);
    }

    @Test
    public void testSyncWorkDir() {
        System.out.println("getSyncDir");
        RotcPreferences instance = new RotcPreferences();
        System.out.println(instance.getSyncDir());
    }

    @Test
    public void testSetSyncDir() {
        System.out.println("setSyncDir");
        RotcPreferences instance = new RotcPreferences();
        String originalPath = instance.getSyncDir();
        instance.setSyncDir("C:/Test Path");
        Assert.assertEquals("C:/Test Path", instance.getSyncDir());
        instance.setSyncDir(originalPath);
    }
}
