package ru.itpark.graduate.pb.web.mbeans;

import ru.itpark.graduate.pb.web.clnt.genapi.TPhoneBookRecordGetListRes;
import ru.itpark.graduate.pb.web.clnt.genapi.TRecordListElement4TPhoneBookRecordGetListRes;
import ru.itpark.graduate.pb.web.facade.PhoneBookFacade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

@ManagedBean(name = "listBean")
@SessionScoped
public class MBeanList {

    public MBeanList(){
        search();
    }

    private String searchText;
    private TRecordListElement4TPhoneBookRecordGetListRes currentEdit;

    private List<TRecordListElement4TPhoneBookRecordGetListRes> rows
            = new ArrayList<TRecordListElement4TPhoneBookRecordGetListRes>();

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<TRecordListElement4TPhoneBookRecordGetListRes> getRows() {
        return rows;
    }

    public void setRows(List<TRecordListElement4TPhoneBookRecordGetListRes> rows) {
        this.rows = rows;
    }

    public TRecordListElement4TPhoneBookRecordGetListRes getCurrentEdit() {
        return currentEdit;
    }

    public void setCurrentEdit(TRecordListElement4TPhoneBookRecordGetListRes currentEdit) {
        this.currentEdit = currentEdit;
    }

    public String search(){
        rows = PhoneBookFacade.getList(this.searchText, null);
        return "list";
    }

    public String clear(){
        this.searchText = "";
        return search();
    }

    public String edit(String guid){
        List<TRecordListElement4TPhoneBookRecordGetListRes> res
                = PhoneBookFacade.getList(null, guid);
        if(!res.isEmpty()){
            currentEdit = res.get(0);
            return "detail";
        }
        return "list";
    }

    public String doUpdate(){
        if(this.currentEdit != null){
            PhoneBookFacade.update(this.currentEdit.getRecordGUID(),
                    this.currentEdit.getFirstName(),
                    this.currentEdit.getLastName(),
                    this.currentEdit.getMiddleName(),
                    this.currentEdit.getEmail(),
                    this.currentEdit.getPhone(),
                    null);
        }
        this.currentEdit = null;
        search();
        return "list";
    }

    public String doDelete(){
        if(this.currentEdit != null){
            PhoneBookFacade.delete(this.currentEdit.getRecordGUID());
        }
        this.currentEdit = null;
        search();
        return "list";
    }

    public String doBackFromEditInput(){
        search();
        return "list";
    }


    public String formatDate(XMLGregorianCalendar date){
        if(date == null){
            return "";
        } else {
            return new SimpleDateFormat("dd.MM.yyyy").format(date.toGregorianCalendar().getTime());
        }
    }

}
