package ie.james;

import db.DAO;
import org.hibernate.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utility.FileParser;

import java.io.IOException;
import java.util.List;
/**
 * Created by User on 13/11/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FrameWorksAss1Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_App {

    DAO dao = null;
    List<Exhibit> exhibits = null;
    Exhibit exhibit = null;

    @Before
    public void load() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        dao = context.getBean(DAOImpl.class);
        exhibit = new Exhibit();
        exhibit.setId("1234");
        exhibit.setDate("13-10-15");
        exhibit.setTitle("Title");
        exhibit.setCreditline("CreditLine");
        exhibit.setGallery_text("galley_text");
        exhibit.setDescription("description");

    }

    @Test
    public void loadJSON() throws IOException {
        FileParser fp = new FileParser();
        exhibits = fp.parseFromJson("C:\\Users\\User\\Desktop\\Frameworks\\682506");
        Assert.assertFalse(exhibits.isEmpty());

    }
    @Test
    public void b_saveToDB() {
        dao.save(exhibit);
        Exhibit e = dao.findExhibitById(exhibit.getId());
        System.out.println(e.getTitle());
        Assert.assertEquals("Compare", "1234", e.getId());

    }

    @Test
    public void updateInfoOnDB() {
        exhibit.setTitle("New Title");
        dao.update(exhibit);
        Exhibit e = dao.findExhibitById(exhibit.getId());
        Assert.assertEquals("Compare", "New Title", e.getTitle());

    }

//    @Test
//    public void deleteFromDB() {
//        dao.delete(exhibit.getId());
//        Assert.assertNull(dao.findExhibitById(exhibit.getId()));
//
//    }


}