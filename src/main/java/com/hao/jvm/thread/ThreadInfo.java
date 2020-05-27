package com.hao.jvm.thread;

import lombok.Data;
import scala.util.control.Exception;

/**
 * <code>ThreadInfo</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-02
 * @version: 1.0
 */
@Data
public class ThreadInfo {

    private byte[] bytes;

    private String name;
}
