package ru.azbn.fe;

/**
 * Created by Alexander on 04.03.2015.
 */
public class FE_NotifyItem {
	public Integer id = 0;
	public Integer hdlr = 0;
	public Class actionClass = this.getClass();
	public Integer number = 0;
	public Boolean autocansel = false;
	public String ticker = "ticker";
	public String title = "title";
	public String text = "text";

	public FE_NotifyItem setId(Integer id) {
		this.id = id;
		return this;
	}

	public FE_NotifyItem setHdlr(Integer hdlr) {
		this.hdlr = hdlr;
		return this;
	}

	public FE_NotifyItem setActionClass(Class actionClass) {
		this.actionClass = actionClass;
		return this;
	}

	public FE_NotifyItem setAutocansel(Boolean autocansel) {
		this.autocansel = autocansel;
		return this;
	}

	public FE_NotifyItem setInfo(Integer number, String ticker, String title, String text) {
		this.number = number;
		this.ticker = ticker;
		this.title = title;
		this.text = text;
		return this;
	}
}
