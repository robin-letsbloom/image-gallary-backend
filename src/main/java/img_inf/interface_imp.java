package img_inf;

import connect_to_mysql.sql;
import image_class.image_props;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class interface_imp implements image_prop {

      private final sql dbms;

    public interface_imp(sql dbms) {
        this.dbms = dbms;
    }

    @Override
    public List<image_props> get_props() {
        return dbms.findAll();
    }
    @Override
    public List<image_props> get_props_aftedate(LocalDate date) {
        return dbms.findImagesOnOrAfterDate(date);
    }

    @Override
    public List<image_props> get_image_props_of_catagory(String category) {
        return dbms.find_images_of_categorty(category);
    }

    @Override
    public List<image_props> get_props_date_and_category(String category, String date) {
        return dbms.find_images_on_date_and_category(category,date);
    }

    @Override
    public List<image_props> get_props_beforedate(LocalDate date) {
        return dbms.find_image_before_that_date(date);
    }
}
//private final to_do_postgress dbms;
//
//@Autowired
//public wk_ls_interface_impl(to_do_postgress dbms) {
//    this.dbms = dbms;
//}
//
//@Override
//public List<to_do_work_ls> get_list() {
//    return dbms.findAll();
//}
//
//@Override
//public to_do_work_ls get_work(long wk_id) {
//    return dbms.findById((int) wk_id).orElse(null);
//}
//
//@Override
//public to_do_work_ls addwork(to_do_work_ls work) {
//    return dbms.save(work);
//}
//
//@Override
//public to_do_work_ls updt_ls(to_do_work_ls wk) {
//    return dbms.save(wk);
//}