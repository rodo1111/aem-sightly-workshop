package cr.prodigious.aem.sightlyworkshop.components.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.jcr.Node;
import javax.jcr.Property;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUse;

@Model(adaptables = SlingHttpServletRequest.class)
public class DateFormatting extends WCMUse {

	private Logger LOG = LoggerFactory.getLogger(this.getClass());

	public String formatDate;
	private String year;

	@Override
	public void activate() throws Exception {
		LOG.debug("Formatting date for custom display.");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
		Date date;
		try {
			String stringDate = get("date", String.class);
			date = formatter.parse(stringDate);
		} catch (NullPointerException e) {
			return;
		}
		String dateFormat = get("dateFormat", String.class);
		formatter = new SimpleDateFormat(dateFormat);
		if (date != null) {
			formatDate = formatter.format(date);
			year = formatYear.format(date).toString();
		}
	}

	public String getUpdatedDate() throws Exception {
		LOG.debug("Retrieving and formatting date");
		Node currPage = getCurrentPage().adaptTo(Node.class);
		Property property = currPage.getNode("jcr:content").getProperty(
				"cq:lastModified");
		Calendar date = property.getDate();
		String month = "";
		switch (date.get(Calendar.MONTH)) {
		case Calendar.JANUARY:
			month = "January";
			break;
		case Calendar.FEBRUARY:
			month = "February";
			break;
		case Calendar.MARCH:
			month = "March";
			break;
		case Calendar.APRIL:
			month = "April";
			break;
		case Calendar.MAY:
			month = "May";
			break;
		case Calendar.JUNE:
			month = "June";
			break;
		case Calendar.JULY:
			month = "July";
			break;
		case Calendar.AUGUST:
			month = "August";
			break;
		case Calendar.SEPTEMBER:
			month = "September";
			break;
		case Calendar.OCTOBER:
			month = "October";
			break;
		case Calendar.NOVEMBER:
			month = "November";
			break;
		case Calendar.DECEMBER:
			month = "December";
			break;
		}
		String retVal = month + " " + date.get(Calendar.DAY_OF_MONTH) + ","
				+ date.get(Calendar.YEAR);
		LOG.info(retVal);
		return retVal;
	}

	public String getYear() {
		LOG.info("year is " + year);
		return year;
	}
}