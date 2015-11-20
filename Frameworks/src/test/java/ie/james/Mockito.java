package ie.james;


        import db.DAO;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;

        import java.util.ArrayList;
        import java.util.List;

        import static org.mockito.Mockito.mock;
        import static org.mockito.Mockito.when;


/**
 * Created by User on 13/11/2015.
 */


public class Mockito {
    DAO dao;
    Exhibit exhibit;

    @Before
    public void setUp() {
        dao = mock(DAO.class);


        exhibit = new Exhibit();
        exhibit.setId("1234");
        exhibit.setDate("13-10-15");
        exhibit.setTitle("Title");
        exhibit.setCreditline("CreditLine");
        exhibit.setGallery_text("galley_text");
        exhibit.setDescription("description");
        dao.save(exhibit);
        List<Exhibit> list = new ArrayList<>();


        Exhibit e = (Exhibit) dao.findExhibitById("1234");
        list.add(e);
        when(list.get(0)).thenReturn(e);


    }

    @Test
    public void get() {
        Assert.assertTrue(exhibit.getId().equals("1234"));

    }


}