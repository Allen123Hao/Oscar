package com.hao.elasticsearch.plugin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.common.CheckedConsumer;
import org.elasticsearch.common.Nullable;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.io.stream.BytesStreamOutput;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.*;

import java.io.IOException;

import static org.elasticsearch.rest.RestRequest.Method.GET;

/**
 * <code>MyRestAction</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/5/8
 * @version: 1.0
 */
public class MyRestAction extends BaseRestHandler {

    private final static Logger LOGGER = LogManager.getLogger(MyRestAction.class);

    @Inject
    public MyRestAction(Settings settings, RestController controller) {
        super(settings);
        controller.registerHandler(GET, "_mytest1/{action}", this);
        controller.registerHandler(GET, "_mytest1", this);
    }

    @Override
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        LOGGER.info("Handle _jettro endpoint");

        String action = request.param("action");
        String strInputAction = "exists";
        if (action != null) {
            LOGGER.info("do something action");
            return createDoSomethingResponse(request, client);
        } else {
            return createMessageResponse(request);
        }
    }

    private RestChannelConsumer createDoSomethingResponse(final RestRequest request, NodeClient client) {
        return channel -> {
            String action = request.param("action");
            Something message = new Something();
            message.action = action;
            XContentBuilder builder = channel.newBuilder();
            builder.startObject();
            message.toXContent(builder, request);
            builder.endObject();
            channel.sendResponse(new BytesRestResponse(RestStatus.OK, builder));
        };
    }

//    private RestChannelConsumer createDoSomethingResponse1(RestRequest request) {
//        return new CheckedConsumer<RestChannel,Exception>(){
//
//            @Override
//            public void accept(RestChannel restChannel) throws Exception {
//                restChannel.newBuilder();
//            }
//        };
//    }

    private RestChannelConsumer createMessageResponse(RestRequest request) {
        return channel -> {
            Message message = new Message();
            XContentBuilder builder = channel.newBuilder();
            builder.startObject();
            message.toXContent(builder, request);
            builder.endObject();
            channel.sendResponse(new BytesRestResponse(RestStatus.OK, builder));
        };
    }


    class Message implements ToXContent {
        @Override
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return builder.field("message", "This is my first plugin");
        }
    }

    class Something implements ToXContent {
        public String action;

        @Override
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            String strReturn;
            if (action != null)
            {
                strReturn = "I can do action " + action;
            }
            else
            {
                strReturn = "I can do anthing here. you order null";
            }
            return builder.field("some", strReturn);
        }
    }
}
