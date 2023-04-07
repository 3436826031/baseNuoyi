package com.ruoyi.framework.interceptor;

import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import com.ruoyi.common.json.JSON;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ServletUtils;

/**
 * 防止重复提交拦截器
 * HandlerInterceptor 拦截器类，只需要去实现这个拦截器的接口
 * @author wl
 */
@Component
public abstract class RepeatSubmitInterceptor implements HandlerInterceptor
{

    /**
     * 这是一个 Java 程序中的方法，它有三个参数：
     *
     * HttpServletRequest：这是一个表示 HTTP 请求的对象，包含了请求的所有信息，如请求头，请求参数等。
     * HttpServletResponse：这是一个表示 HTTP 响应的对象，包含了响应的所有信息，如响应头，响应状态码等。
     * Object handler：这是该请求对应的处理器对象，通常是一个控制器类的实例。
     * 该方法通常被用作拦截器中的预处理方法，在请求被处理前调用。拦截器可以用来对请求进行预处理，如对请求数据进行验证，修改请求参数等。
     *
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        if (handler instanceof HandlerMethod)
        {
            //接口对应的Controller 即将调用的方法 
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            //获取该方法，是否存在@RepeatSubmit注解（@RepeatSubmit是一个自定义的注解）
            RepeatSubmit annotation = method.getAnnotation(RepeatSubmit.class);
            
            //存在注解，开启重复提交拦截
            if (annotation != null)
            {
                if (this.isRepeatSubmit(request, annotation))
                {
                    AjaxResult ajaxResult = AjaxResult.error(annotation.message());
                    ServletUtils.renderString(response, JSON.marshal(ajaxResult));
                    return false;
                }
            }
            return true;
        }
        else
        {
            return true;
        }
    }

    /**
     * 验证是否重复提交由子类实现具体的防重复提交的规则
     *
     * @param request 请求对象
     * @param annotation 防复注解
     * @return 结果
     */
    public abstract boolean isRepeatSubmit(HttpServletRequest request, RepeatSubmit annotation) throws Exception;
}
