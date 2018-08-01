package com.infoshareacademy.jjdd4.wildhogs.logic;
import com.infoshareacademy.jjdd4.wildhogs.app.Configuration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;


class JSONProviderTest {

    @Test
    void read() {

        Properties properties = new Properties();
        properties.setProperty( "jsonPath", "invalid_file" );
        Configuration configuration = new Configuration( properties );
        JSONProvider json = new JSONProvider();
        JSONObject jsonObject = json.read( String.valueOf( configuration ) );
        assertThat( jsonObject ).isNotNull();
        assertThat( jsonObject.isEmpty() ).isTrue();
    }
}