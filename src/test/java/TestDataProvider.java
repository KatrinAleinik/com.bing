import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.Map;

public class TestDataProvider {

    @DataProvider(name = "testData")
    public Object[][] createData() {
        Yaml yaml = new Yaml();
        Map<String, Map> obj = yaml.load(this.getClass().getClassLoader().getResourceAsStream("data.yaml"));
        List<Map> data = (List<Map>) obj.get("data");
        int size = data.size();
        Object[][] credentials = new Object[size][2];
        for (int i = 0; i < size; i++) {
            credentials[i][0] = data.get(i).get("input");
            credentials[i][1] = data.get(i).get("expected");
        }
        return credentials;
    }

}
