package com.rocketteam.iwastecash.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

public class Purchase implements JsonSerializable {
	private UUID id;
	private Date created;
	private int order;
	private String comments;
	private String category;
	private String currencyCode;
	private BigDecimal amountTotal;
	private BigDecimal amountOffset;
	private boolean inSync;

	public UUID getId() {
		return id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getAmountOffset() {
		return amountOffset;
	}

	public void setAmountOffset(BigDecimal amountOffset) {
		this.amountOffset = amountOffset;
	}

	public BigDecimal getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(BigDecimal amountTotal) {
		this.amountTotal = amountTotal;
	}

	public boolean isInSync() {
		return inSync;
	}

	public void setInSync(boolean inSync) {
		this.inSync = inSync;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	public Purchase(UUID id, Date created, int order, String comments
			, String category, BigDecimal amountTotal, BigDecimal amountOffset
			, String currencyCode)
	{
		this.id = id;
		this.created = created;
		this.order = 0;
		this.comments = comments;
		this.category = category;
		this.amountTotal = amountTotal;
		this.amountOffset = amountOffset;
		this.currencyCode = currencyCode;
		this.inSync = false;
	}

	public Purchase(String category, String comments, BigDecimal total, BigDecimal offset, String currencyCode) {
		this(UUID.randomUUID(), new Date(), 0, comments, category, total, offset, "COP");
	}
	
	public Purchase(String category, String comments, BigDecimal total) 
	{
		this(category, comments, total, new BigDecimal(0.0), "COP");
	}
	
	public static Purchase fromJson(JSONObject j) {
		
		Purchase p = null;
		
		try {
			String sid = j.getString("id");
			String screated = j.getString("created");
			int order = j.getInt("order");
			String comments = j.getString("comments");
			String category = j.getString("category");
			String samountTotal = j.getString("amountTotal");
			String samountOffset = j.getString("amountOffset");
			String currencyCode = j.getString("currencyCode");
			
			DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			
			UUID id = UUID.fromString(sid);
			Date created = df.parse(screated);
			BigDecimal amountTotal = new BigDecimal(samountTotal);
			BigDecimal amountOffset = new BigDecimal(samountOffset);
			
			p = new Purchase(id, created, order, comments, category, amountTotal, amountOffset, currencyCode);
			
		} catch (JSONException e) {
			// Json get fails
			e.printStackTrace();
		} catch (ParseException e) {
			// Date parse error
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public JSONObject getJson() {
		// TODO Auto-generated method stub
		JSONObject j = new JSONObject();
		try {
			DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			String screated = df.format(created);
			j.put("id", id.toString());
			j.put("created", screated);
			j.put("order", order);
			j.put("comments", comments);
			j.put("category", category);
			j.put("amountTotal", amountTotal);
			j.put("amountOffset", amountOffset);
			j.put("currencyCode", currencyCode);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return j;
	}
}
