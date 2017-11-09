<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>

<%@page import="javax.portlet.RenderRequest"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%> 
<%@page import="javax.portlet.ActionRequest"%>

<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.text.Format"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil"%>
<%@page import="java.text.DateFormat"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
    WindowState windowState = null;
    PortletMode portletMode = null;

    PortletURL currentURLObj = null;

    if (renderRequest != null)
    {
        windowState = renderRequest.getWindowState();
        portletMode = renderRequest.getPortletMode();
        currentURLObj = PortletURLUtil.getCurrent(renderRequest, renderResponse);
    }
    else if (resourceRequest != null)
    {
        windowState = resourceRequest.getWindowState();
        portletMode = resourceRequest.getPortletMode();
        currentURLObj = PortletURLUtil.getCurrent(resourceRequest, resourceResponse);
    }

    String currentURL = currentURLObj.toString();
    PortletPreferences preferences = renderRequest.getPreferences();
    String portletResource = ParamUtil.getString(request, "portletResource");

    if (Validator.isNotNull(portletResource))
    {
        preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
    }
    
    Format dateFormat = FastDateFormatFactoryUtil.getSimpleDateFormat("dd MMM yyyy HH:mm", locale, timeZone) ;
    DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
    shortDateFormat.setTimeZone(timeZone);
%>