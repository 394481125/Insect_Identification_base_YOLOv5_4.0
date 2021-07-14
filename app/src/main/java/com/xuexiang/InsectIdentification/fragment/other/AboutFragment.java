/*
 * Copyright (C) 2021 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.xuexiang.InsectIdentification.fragment.other;

import android.widget.TextView;

import com.xuexiang.InsectIdentification.R;
import com.xuexiang.InsectIdentification.core.BaseFragment;
import com.xuexiang.InsectIdentification.core.webview.AgentWebActivity;
import com.xuexiang.InsectIdentification.utils.Utils;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xui.widget.grouplist.XUIGroupListView;
import com.xuexiang.xutil.app.AppUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;

/**
 * @author xuexiang
 * @since 2019-10-30 00:02
 */
@Page(name = "关于")
public class AboutFragment extends BaseFragment {

    @BindView(R.id.tv_version)
    TextView mVersionTextView;
    @BindView(R.id.about_list)
    XUIGroupListView mAboutGroupListView;
    @BindView(R.id.tv_copyright)
    TextView mCopyrightTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    protected void initViews() {
        mVersionTextView.setText(String.format("版本号：%s", AppUtils.getAppVersionName()));

        XUIGroupListView.newSection(getContext())
                .addItemView(mAboutGroupListView.createItemView(getResources().getString(R.string.about_item_homepage)), v -> AgentWebActivity.goWeb(getContext(), getString(R.string.url_project_github)))
//                .addItemView(mAboutGroupListView.createItemView(getResources().getString(R.string.about_item_author_github)), v -> AgentWebActivity.goWeb(getContext(), getString(R.string.url_author_github)))
//                .addItemView(mAboutGroupListView.createItemView(getResources().getString(R.string.about_item_donation_link)), v -> AgentWebActivity.goWeb(getContext(), getString(R.string.url_donation_link)))
//                .addItemView(mAboutGroupListView.createItemView(getResources().getString(R.string.about_item_add_qq_group)), v -> AgentWebActivity.goWeb(getContext(), getString(R.string.url_add_qq_group)))
//                .addItemView(mAboutGroupListView.createItemView(getResources().getString(R.string.title_user_protocol)), v -> Utils.gotoProtocol(this, false, false))
//                .addItemView(mAboutGroupListView.createItemView(getResources().getString(R.string.title_privacy_protocol)), v -> Utils.gotoProtocol(this, true, false))
                .addTo(mAboutGroupListView);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.CHINA);
        String currentYear = dateFormat.format(new Date());
        mCopyrightTextView.setText(String.format(getResources().getString(R.string.about_copyright), currentYear));
    }
}
