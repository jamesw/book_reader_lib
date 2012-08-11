/*
 * Copyright (C) 2012 Alex Kuiper
 * 
 * This file is part of PageTurner
 *
 * PageTurner is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PageTurner is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PageTurner.  If not, see <http://www.gnu.org/licenses/>.*
 */

package pageturner;

import java.util.List;

import org.acra.ACRA;
import org.acra.annotation.ReportsCrashes;
import org.acra.ReportingInteractionMode;

import roboguice.application.RoboApplication;

import android.content.Context;
import android.content.Intent;

import com.google.inject.Module;
/**import com.greystripe.sdk.GSAd;
import com.greystripe.sdk.GSAdErrorCode;
import com.greystripe.sdk.GSAdListener;
import com.greystripe.sdk.GSMobileBannerAdView;
import com.mobclix.android.sdk.MobclixAdView;
import com.mobclix.android.sdk.MobclixMMABannerXLAdView;**/

//@ReportsCrashes(formKey = "dEZrZHhvcnUwUF94ZFJEY1JUSnFhUWc6MQ")
//c68b3679f0615ca1ac73985df19ca096 ZOHO AUTH TOKEN
@ReportsCrashes(formKey = "", // will not be used

//formUri = "https://creator.zoho.com/api/json/reder-crash-reports/Reder_crash_reports/add/scope=creatorapi&authtoken=c68b3679f0615ca1ac73985df19ca096",
formUri = "http://tranquil-sands-8101.herokuapp.com/crash_reports",
//formUriBasicAuthLogin = "cloudcity1", // optional
//formUriBasicAuthPassword = "cloud1212", // optional
socketTimeout = 30000,
mode = ReportingInteractionMode.SILENT)

public class BookLib extends RoboApplication {
	
	protected void addApplicationModules(List<Module> modules) {
		modules.add(new PageTurnerModule());
	}

	@Override
	public void onCreate() {
		ACRA.init(this);
		super.onCreate();
	}

}
