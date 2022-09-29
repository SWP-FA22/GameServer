/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.lang.reflect.Field;
import org.json.JSONObject;

/**
 *
 * @author yuyu
 */
public class EntityBase extends JSONObject {

    protected void updateProps() {
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                put(field.getName(), field.get(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void updateProp(String propName, Object value) {
        try {
            put(propName, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
