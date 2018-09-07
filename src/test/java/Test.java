import com.alibaba.fastjson.JSON;
import com.jieve.openapi.varena.api.VarenaApi;
import com.jieve.openapi.varena.utils.InitUtil;

import java.io.IOException;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Jieve
 * @Date 2018/9/5 22:02
 * @Version 1.0
 **/
public class Test {

    static {
        try {
            InitUtil.init("src/main/resources/config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//            System.out.println(HttpHelper.get(Constant.API_DOMAIN_NAME, "/data-service/dota2/public/raw/heroes", null));
//        System.out.println(JSON.toJSONString(VarenaApi.getAllHeros()));

        System.out.println(JSON.toJSONString(VarenaApi.getAllItems()));

//        System.out.println(new String[0].length >= 0);

//        StringBuilder sb = new StringBuilder("aaa=bbb&");
//        System.out.println(sb.substring(0, sb.length() - 1));

//        System.out.println(200 == 200);

    }
}
