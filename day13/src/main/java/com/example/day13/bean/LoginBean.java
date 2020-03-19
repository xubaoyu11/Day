package com.example.day13.bean;

/**
 * @ProjectName: My Application4
 * @Package: com.example.day13.bean
 * @ClassName: LoginBean
 * @Description: java类作用描述
 * @Author: deshuai
 * @CreateDate: 2020/3/12 21:41
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/12 21:41
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LoginBean {
    private String status;
    private String message;

    private Result result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class  Result{
        String userId;
        String sessionId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}
