/*
 * Copyright (c) 2012, FDV Solutions S.A.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the FDV Solutions S.A. nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL FDV Solutions S.A. BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package ar.com.fdvs.dj.domain;

import ar.com.fdvs.dj.domain.entities.Entity;

public class DJCrosstabRow extends DJBaseElement{

	private static final long serialVersionUID = Entity.SERIAL_VERSION_UID;

	private ColumnProperty property;
	private int height = -1;
	private int headerWidth = -1;
	private int totalHeaderHeight = -1;

	private String title;

	private boolean showTotals = false;

	private Style totalStyle;
	private Style totalHeaderStyle;
	private Style headerStyle;
	
	private String totalLegend;
	
	private DJHyperLink link;

	public Style getTotalStyle() {
		return totalStyle;
	}
	public void setTotalStyle(Style totalStyle) {
		this.totalStyle = totalStyle;
	}
	public boolean isShowTotals() {
		return showTotals;
	}
	public void setShowTotals(boolean showTotals) {
		this.showTotals = showTotals;
	}
	public ColumnProperty getProperty() {
		return property;
	}
	public void setProperty(ColumnProperty property) {
		this.property = property;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeaderWidth() {
		return headerWidth;
	}
	public void setHeaderWidth(int headerWidth) {
		this.headerWidth = headerWidth;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Style getTotalHeaderStyle() {
		return totalHeaderStyle;
	}
	public void setTotalHeaderStyle(Style totalHeaderStyle) {
		this.totalHeaderStyle = totalHeaderStyle;
	}
	public Style getHeaderStyle() {
		return headerStyle;
	}
	public void setHeaderStyle(Style headerStyle) {
		this.headerStyle = headerStyle;
	}
	public int getTotalHeaderHeight() {
		return totalHeaderHeight;
	}
	public void setTotalHeaderHeight(int totalHeaderHeight) {
		this.totalHeaderHeight = totalHeaderHeight;
	}
	public DJHyperLink getLink() {
		return link;
	}
	public void setLink(DJHyperLink link) {
		this.link = link;
	}
	public String getTotalLegend() {
		return totalLegend;
	}
	public void setTotalLegend(String totalLegend) {
		this.totalLegend = totalLegend;
	}

}
