package csu.web.mypetstore.action;

import java.io.Serializable;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.SimpleMessage;

abstract class AbstractActionBean implements ActionBean, Serializable {
    private static final long serialVersionUID = -1767714708233127983L;
    protected static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    protected transient ActionBeanContext context;

    AbstractActionBean() {
    }

    protected void setMessage(String value) {
        this.context.getMessages().add(new SimpleMessage(value, new Object[0]));
    }

    public ActionBeanContext getContext() {
        return this.context;
    }

    public void setContext(ActionBeanContext context) {
        this.context = context;
    }
}
