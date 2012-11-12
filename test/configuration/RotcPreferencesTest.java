package configuration;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author javarobots <javarobots74@gmail.com>
 */
public class RotcPreferencesTest {

    @Test
    public void testGetWorkDir() {
        System.out.println("getWorkDir");
        RotcPreferences instance = RotcPreferences.getRotcPreferences();
        System.out.println(instance.getWorkDir());
    }

    @Test
    public void testSetWorkDir() {
        System.out.println("setWorkDir");
        RotcPreferences instance = RotcPreferences.getRotcPreferences();
        String originalPath = instance.getWorkDir();
        instance.setWorkDir("C:/Test Path");
        Assert.assertEquals("C:/Test Path", instance.getWorkDir());
        instance.setWorkDir(originalPath);
    }

    @Test
    public void testSyncWorkDir() {
        System.out.println("getSyncDir");
        RotcPreferences instance = RotcPreferences.getRotcPreferences();
        System.out.println(instance.getSyncDir());
    }

    @Test
    public void testSetSyncDir() {
        System.out.println("setSyncDir");
        RotcPreferences instance = RotcPreferences.getRotcPreferences();
        String originalPath = instance.getSyncDir();
        instance.setSyncDir("C:/Test Path");
        Assert.assertEquals("C:/Test Path", instance.getSyncDir());
        instance.setSyncDir(originalPath);
    }
}
