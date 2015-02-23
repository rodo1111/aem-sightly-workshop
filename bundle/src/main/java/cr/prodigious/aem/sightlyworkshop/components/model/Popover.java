/**
 * AEM Sightly Workshop Components Model package.
 */
package cr.prodigious.aem.sightlyworkshop.components.model;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

/**
 * Entity class for the Popover.
 * 
 * @author Rodolfo Oviedo
 */
@Model(adaptables = Resource.class)
public class Popover {

	/**
	 * Class attributes.
	 */
	@Inject
	private String buttonTitle;

	@Inject
	private String popoverTitle;

	@Inject
	private String popoverMessage;

	/**
	 * @return the buttonTitle
	 */
	public String getButtonTitle() {
		return buttonTitle;
	}

	/**
	 * @param buttonTitle
	 *            the buttonTitle to set
	 */
	public void setButtonTitle(String buttonTitle) {
		this.buttonTitle = buttonTitle;
	}

	/**
	 * @return the popoverTitle
	 */
	public String getPopoverTitle() {
		return popoverTitle;
	}

	/**
	 * @param popoverTitle
	 *            the popoverTitle to set
	 */
	public void setPopoverTitle(String popoverTitle) {
		this.popoverTitle = popoverTitle;
	}

	/**
	 * @return the popoverMessage
	 */
	public String getPopoverMessage() {
		return popoverMessage;
	}

	/**
	 * @param popoverMessage
	 *            the popoverMessage to set
	 */
	public void setPopoverMessage(String popoverMessage) {
		this.popoverMessage = popoverMessage;
	}

	/**
	 * Method to return if the component has a valid configuration.
	 * 
	 * @return Result of the operation
	 */
	public boolean isConfigValid() {
		return StringUtils.isNotBlank(buttonTitle)
				&& StringUtils.isNotBlank(popoverTitle)
				&& StringUtils.isNotBlank(popoverMessage);
	}

}
