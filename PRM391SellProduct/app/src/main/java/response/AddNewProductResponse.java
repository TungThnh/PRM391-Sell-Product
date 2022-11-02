package response;

import java.io.Serializable;

public class AddNewProductResponse implements Serializable {
    private float id;
    private String maker_id;
    private String maker_date;
    private String checker_id;
    private String checker_date;
    private String mod_no = null;
    private String record_status;
    private String auth_status;
    private String ext_value = null;
    private String fts_value = null;
    private String code;
    private String name;
    private String description;
    private String price;
    private String unit;
    private float quantity;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getMaker_id() {
        return maker_id;
    }

    public String getMaker_date() {
        return maker_date;
    }

    public String getChecker_id() {
        return checker_id;
    }

    public String getChecker_date() {
        return checker_date;
    }

    public String getMod_no() {
        return mod_no;
    }

    public String getRecord_status() {
        return record_status;
    }

    public String getAuth_status() {
        return auth_status;
    }

    public String getExt_value() {
        return ext_value;
    }

    public String getFts_value() {
        return fts_value;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public float getQuantity() {
        return quantity;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setMaker_id(String maker_id) {
        this.maker_id = maker_id;
    }

    public void setMaker_date(String maker_date) {
        this.maker_date = maker_date;
    }

    public void setChecker_id(String checker_id) {
        this.checker_id = checker_id;
    }

    public void setChecker_date(String checker_date) {
        this.checker_date = checker_date;
    }

    public void setMod_no(String mod_no) {
        this.mod_no = mod_no;
    }

    public void setRecord_status(String record_status) {
        this.record_status = record_status;
    }

    public void setAuth_status(String auth_status) {
        this.auth_status = auth_status;
    }

    public void setExt_value(String ext_value) {
        this.ext_value = ext_value;
    }

    public void setFts_value(String fts_value) {
        this.fts_value = fts_value;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
