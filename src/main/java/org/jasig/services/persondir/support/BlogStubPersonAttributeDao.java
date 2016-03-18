package org.jasig.services.persondir.support;

import org.jasig.services.persondir.IPersonAttributes;
import org.springframework.http.HttpRequest;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by NS on 2016/3/15.
 * 用于给客户端返回信息
 */
public class BlogStubPersonAttributeDao extends StubPersonAttributeDao {
    @Override
    public IPersonAttributes getPerson(String uid) {

        Map<String, List<Object>> attributes = new HashMap<String, List<Object>>();
        attributes.put("userid", Collections.singletonList((Object) 1));
        attributes.put("cnblogUsername", Collections.singletonList((Object)uid));
        attributes.put("cnblogPassword", Collections.singletonList((Object)"admin"));
        attributes.put("test", Collections.singletonList((Object)"test"));
        return new AttributeNamedPersonImpl(attributes);
    }
}
