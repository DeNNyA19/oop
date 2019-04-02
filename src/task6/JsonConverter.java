package task6;

import org.json.JSONObject;

public class JsonConverter {

    public void convert(Object var1) {
        System.out.println("Passed object formatted into JSON: ".concat((new JSONObject(var1)).toString()));
    }
}
