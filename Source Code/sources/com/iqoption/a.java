package com.iqoption;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.v4.app.FrameMetricsAggregator;
import android.support.v4.view.InputDeviceCompat;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.iqoption.d.ajr;
import com.iqoption.d.bt;
import com.iqoption.d.fp;
import com.iqoption.d.ft;
import com.iqoption.d.ks;
import com.iqoption.d.kw;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.x.R;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.remote.exception.UnexpectedResponseException;

/* compiled from: DataBinderMapperImpl */
public class a extends DataBinderMapper {
    private static final SparseIntArray pc = new SparseIntArray(FrameMetricsAggregator.EVERY_DURATION);

    /* compiled from: DataBinderMapperImpl */
    private static class a {
        static final SparseArray<String> pd = new SparseArray(8);

        static {
            pd.put(0, "_all");
            pd.put(1, "dialog");
            pd.put(3, "handler");
            pd.put(6, "toast");
            pd.put(2, "fragment");
            pd.put(7, "viewHelper");
            pd.put(4, "handlers");
            pd.put(5, "holder");
        }
    }

    static {
        pc.put(R.layout.deposit_payment_successfully_completed, 1);
        pc.put(R.layout.fragment_trading_history_search_details, 2);
        pc.put(R.layout.portfolio_title, 3);
        pc.put(R.layout.chat_user_image_message_item, 4);
        pc.put(R.layout.bottom_sheet_portfolio_filter_chooser, 5);
        pc.put(R.layout.fragment_kyc_question_warning, 6);
        pc.put(R.layout.fragment_welcome_login, 7);
        pc.put(R.layout.right_panel_delegate_crypto_closed, 8);
        pc.put(R.layout.fragment_video_education_categories, 9);
        pc.put(R.layout.account_security_confirm_phone_2step_auth_fragment, 10);
        pc.put(R.layout.buy_new_dialog_view, 11);
        pc.put(R.layout.chat_attachment_image_item, 12);
        pc.put(R.layout.nps_score_fragment, 13);
        pc.put(R.layout.fragment_withdraw_fields, 14);
        pc.put(R.layout.string_basket_switch_item, 15);
        pc.put(R.layout.portfolio_pending_item, 16);
        pc.put(R.layout.fragment_news_and_updates, 17);
        pc.put(R.layout.close_position_delegate, 18);
        pc.put(R.layout.activity_withdraw, 19);
        pc.put(R.layout.cfd_confirm_dialog_view, 20);
        pc.put(R.layout.micro_portfolio_pending_item, 21);
        pc.put(R.layout.fragment_kyc_documents_upload, 22);
        pc.put(R.layout.dialog_overnight_fee_info, 23);
        pc.put(R.layout.dialog_otn_commision_changed, 24);
        pc.put(R.layout.fragment_kyc_reportable, 25);
        pc.put(R.layout.fragment_operation_history, 26);
        pc.put(R.layout.fragment_verify_details, 27);
        pc.put(R.layout.right_panel_delegate_crypto_main, 28);
        pc.put(R.layout.more_trading_opportunities, 29);
        pc.put(R.layout.fragment_commission_change, 30);
        pc.put(R.layout.right_panel_delegate_cfd_on_open_confirmation, 31);
        pc.put(R.layout.close_crypto_position_delegate, 32);
        pc.put(R.layout.portfolio_exp_info, 33);
        pc.put(R.layout.dialog_whats_new, 34);
        pc.put(R.layout.dialog_closed_deals, 35);
        pc.put(R.layout.fragment_withdrawal_crypto_3ds, 36);
        pc.put(R.layout.price_movements_filter_options, 37);
        pc.put(R.layout.fragment_kyc_start_non_regulated, 38);
        pc.put(R.layout.open_binary_option_group_item, 39);
        pc.put(R.layout.chat_transfer_dialog_message_item, 40);
        pc.put(R.layout.micro_smart_feed, 41);
        pc.put(R.layout.fragment_kyc_radio_button, 42);
        pc.put(R.layout.micro_portfolio_mkt_on_open_single_group_item, 43);
        pc.put(R.layout.fragment_vip_request_call, 44);
        pc.put(R.layout.video_education_search_suggestion_item, 45);
        pc.put(R.layout.fragment_two_step_auth, 46);
        pc.put(R.layout.fragment_kyc_id_declined, 47);
        pc.put(R.layout.closed_portfolio_item, 48);
        pc.put(R.layout.micro_portfolio_open_header_item, 49);
        pc.put(R.layout.dialog_pending_removal, 50);
        pc.put(R.layout.base_smart_fragment, 51);
        pc.put(R.layout.left_menu_item, 52);
        pc.put(R.layout.dialpad, 53);
        pc.put(R.layout.account_security_confirm_code_expired_fragment, 54);
        pc.put(R.layout.commission_view, 55);
        pc.put(R.layout.fragment_quiz_leaderboard_filter_item, 56);
        pc.put(R.layout.deposit_payment_method_item, 57);
        pc.put(R.layout.price_movements_fragment, 58);
        pc.put(R.layout.fragment_left_panel, 59);
        pc.put(R.layout.fragment_traderoom_restriction, 60);
        pc.put(R.layout.fragment_trading_history_search_setting, 61);
        pc.put(R.layout.strike_item, 62);
        pc.put(R.layout.tools_content_settings, 63);
        pc.put(R.layout.micro_other_video_feed, 64);
        pc.put(R.layout.deposit_card_back_side, 65);
        pc.put(R.layout.dialog_quiz_user_profile, 66);
        pc.put(R.layout.macro_feed_options, 67);
        pc.put(R.layout.micro_portfolio_page_closed_positions, 68);
        pc.put(R.layout.fragment_kyc_documents_intro, 69);
        pc.put(R.layout.dialog_confirm_sell_position, 70);
        pc.put(R.layout.chat_room_public_toolbar, 71);
        pc.put(R.layout.fragment_account_security_passcode, 72);
        pc.put(R.layout.micro_portfolio_cfd_item, 73);
        pc.put(R.layout.open_cfd_item, 74);
        pc.put(R.layout.withdraw_verify_button, 75);
        pc.put(R.layout.fragment_trading_history_set_asset, 76);
        pc.put(R.layout.fragment_kyc_question_multi_choice, 77);
        pc.put(R.layout.kdj_dialog, 78);
        pc.put(R.layout.portfolio_pending_empty_item, 79);
        pc.put(R.layout.fragment_otn_leading_board_user_board_trading, 80);
        pc.put(R.layout.fragment_right_panel, 81);
        pc.put(R.layout.micro_feed_title, 82);
        pc.put(R.layout.dialog_confirm_close_pending_position, 83);
        pc.put(R.layout.price_movements_high_frequency_layout, 84);
        pc.put(R.layout.fragment_withdrawal_crypto_kyc, 85);
        pc.put(R.layout.dialpad_dot, 86);
        pc.put(R.layout.chat_room_private_toolbar, 87);
        pc.put(R.layout.dialog_closed_deals_item_do, 88);
        pc.put(R.layout.fragment_pending_order_executed, 89);
        pc.put(R.layout.right_panel_delegate_cfd_main, 90);
        pc.put(R.layout.right_panel_delegate_digital_call_put, 91);
        pc.put(R.layout.portfolio_micro_filter_item, 92);
        pc.put(R.layout.otn_leader_board_current_user_item, 93);
        pc.put(R.layout.string_basket_item, 94);
        pc.put(R.layout.confirm_dialog_view, 95);
        pc.put(R.layout.fragment_account_security_passcode_error, 96);
        pc.put(R.layout.chat_text_message_body_item, 97);
        pc.put(R.layout.fragment_kyc_phone_confirmed, 98);
        pc.put(R.layout.fragment_kyc_finish, 99);
        pc.put(R.layout.signal_item, 100);
        pc.put(R.layout.deposit_old_amount_line, 101);
        pc.put(R.layout.portfolio_exp_single_group_item, 102);
        pc.put(R.layout.left_menu_item_with_progress, 103);
        pc.put(R.layout.portfolio_app_bar, 104);
        pc.put(R.layout.chat_image_message_tail_item, 105);
        pc.put(R.layout.right_panel_delegate_digital, 106);
        pc.put(R.layout.chat_file_picker_item, 107);
        pc.put(R.layout.bottom_sheet_portfolio_tpsl_chooser, 108);
        pc.put(R.layout.portfolio_mkt_on_open_item, 109);
        pc.put(R.layout.video_education_simple_category_item, 110);
        pc.put(R.layout.dialog_pro_trader_selected, 111);
        pc.put(R.layout.micro_article_feed, 112);
        pc.put(R.layout.fragment_quiz_off_air_title, 113);
        pc.put(R.layout.active_sessions_fragment, 114);
        pc.put(R.layout.session_other_item, 115);
        pc.put(R.layout.instrument_type_bottom_sheet_item, 116);
        pc.put(R.layout.micro_tweet_feed, 117);
        pc.put(R.layout.deposit_page_content, 118);
        pc.put(R.layout.fragment_verify_status, 119);
        pc.put(R.layout.whats_new_dialog_templates, ChartTimeInterval.CANDLE_2m);
        pc.put(R.layout.micro_portfolio_exp_group_item, 121);
        pc.put(R.layout.fragment_quiz_update_delegate, 122);
        pc.put(R.layout.fragment_pro_trader_more, 123);
        pc.put(R.layout.string_save_as_tamplet, 124);
        pc.put(R.layout.tools_fragment, 125);
        pc.put(R.layout.fragment_kyc_cysec, 126);
        pc.put(R.layout.activity_pro_deposit, 127);
        pc.put(R.layout.high_frequency_panel_item, 128);
        pc.put(R.layout.left_menu_item_list, 129);
        pc.put(R.layout.vip_education_item_view, 130);
        pc.put(R.layout.tools_content_templates, 131);
        pc.put(R.layout.fragment_otn_leading_board, 132);
        pc.put(R.layout.item_locale_asset_country_suggest, 133);
        pc.put(R.layout.operation_history_single_selection, 134);
        pc.put(R.layout.item_overnight_fee_schedule, 135);
        pc.put(R.layout.fragment_kyc_email, 136);
        pc.put(R.layout.fragment_withdraw_verify_page, 137);
        pc.put(R.layout.dialog_pro_application_status, 138);
        pc.put(R.layout.video_education_video_item, 139);
        pc.put(R.layout.fragment_welcome_trending, 140);
        pc.put(R.layout.fragment_kyc_risks, 141);
        pc.put(R.layout.deposit_payment_completed_page, 142);
        pc.put(R.layout.micro_portfolio_pending_info, 143);
        pc.put(R.layout.bottom_sheet_chooser, 144);
        pc.put(R.layout.micro_portfolio_total_pager_page, 145);
        pc.put(R.layout.numpad, 146);
        pc.put(R.layout.price_movements_attention, 147);
        pc.put(R.layout.rate_us_dialog, 148);
        pc.put(R.layout.news_and_updates_item, 149);
        pc.put(R.layout.fragment_welcome_onboarding, 150);
        pc.put(R.layout.open_digital_option_item, 151);
        pc.put(R.layout.fragment_multiplier_chooser, 152);
        pc.put(R.layout.fragment_micro_room_list, 153);
        pc.put(R.layout.portfolio_cfd_info, 154);
        pc.put(R.layout.account_security_resend_email_fragment, 155);
        pc.put(R.layout.portfolio_pending_single_group_item, 156);
        pc.put(R.layout.portfolio_page_open_positions, 157);
        pc.put(R.layout.left_menu_item_terms_and_conditions, 158);
        pc.put(R.layout.smart_feed_fragment, 159);
        pc.put(R.layout.chat_text_message_full_item, 160);
        pc.put(R.layout.price_movements_filter_fragment, 161);
        pc.put(R.layout.micro_portfolio_open_empty_item, 162);
        pc.put(R.layout.fragment_kyc_email_confirmed, 163);
        pc.put(R.layout.item_welcome_trending, 164);
        pc.put(R.layout.fragment_kyc_address_declined, 165);
        pc.put(R.layout.chat_room_cant_send_layout, 166);
        pc.put(R.layout.dialog_portfolio_invest_info, 167);
        pc.put(R.layout.indicator_info_item, 168);
        pc.put(R.layout.chat_fragment_attachment_picker, 169);
        pc.put(R.layout.keyboard_tpsl, 170);
        pc.put(R.layout.portfolio_filter_item, 171);
        pc.put(R.layout.operation_search_result_item, 172);
        pc.put(R.layout.chat_file_message_head_item, 173);
        pc.put(R.layout.fragment_kyc_acceptable_documents, 174);
        pc.put(R.layout.withdraw_field_constructor, 175);
        pc.put(R.layout.dialog_otn_expectation, 176);
        pc.put(R.layout.splash, 177);
        pc.put(R.layout.fragment_operation_history_options, 178);
        pc.put(R.layout.dialog_closed_deals_header_list_do, 179);
        pc.put(R.layout.withdraw_history_payout_item, 180);
        pc.put(R.layout.open_digital_option_group_item, 181);
        pc.put(R.layout.fragment_token_balance, 182);
        pc.put(R.layout.dialog_closed_deals_header_cfd, 183);
        pc.put(R.layout.micro_portfolio_page_open_positions, 184);
        pc.put(R.layout.fragment_kyc_date_of_birth, 185);
        pc.put(R.layout.macro_video_feed, 186);
        pc.put(R.layout.active_tools_item, 187);
        pc.put(R.layout.fragment_quiz_leaderboard_filter, 188);
        pc.put(R.layout.layout_welcome_policy, 189);
        pc.put(R.layout.dialog_congrat_otn_emission_executed, 190);
        pc.put(R.layout.chat_like_dislike_message_item, 191);
        pc.put(R.layout.string_basket_remove_all_item, 192);
        pc.put(R.layout.fragment_kyc_email_confirm, 193);
        pc.put(R.layout.feed_options, 194);
        pc.put(R.layout.account_security_confirm_code_fragment, 195);
        pc.put(R.layout.dialog_closed_deals_item_cfd_aggregated, 196);
        pc.put(R.layout.fragment_signals, 197);
        pc.put(R.layout.fragment_pro_trader_active, 198);
        pc.put(R.layout.bottom_sheet_otn_emission_history, 199);
        pc.put(R.layout.withdraw_limit_reason_dialog, 200);
        pc.put(R.layout.base_smart_dialog_fragment, 201);
        pc.put(R.layout.deposit_crypto_payment_method_item, 202);
        pc.put(R.layout.fragment_quiz_question_language, 203);
        pc.put(R.layout.nps_completed_fragment, 204);
        pc.put(R.layout.dialog_closed_deals_item_cfd, 205);
        pc.put(R.layout.fragment_kyc_legal_name, 206);
        pc.put(R.layout.dialog_commision_info, 207);
        pc.put(R.layout.dialog_closed_deals_header_list_binary, 208);
        pc.put(R.layout.local_toast_layout, 209);
        pc.put(R.layout.kyc_toolbar_layout, 210);
        pc.put(R.layout.whats_new_dialog_experimental_deposit_page, 211);
        pc.put(R.layout.right_panel_delegate_cfd_confirmation, 212);
        pc.put(R.layout.open_cfd_group_item, 213);
        pc.put(R.layout.micro_portfolio_exp_header_item, 214);
        pc.put(R.layout.right_panel_delegate_turbo_binary_call_put, 215);
        pc.put(R.layout.portfolio_exp_item, 216);
        pc.put(R.layout.fragment_withdrawal_crypto_wallet, 217);
        pc.put(R.layout.session_title, 218);
        pc.put(R.layout.fragment_video_education_videos, 219);
        pc.put(R.layout.fragment_withdrawal_crypto_pager, 220);
        pc.put(R.layout.micro_portfolio_cfd_group_item, 221);
        pc.put(R.layout.portfolio_exp_header_item, 222);
        pc.put(R.layout.item_country_suggest, 223);
        pc.put(R.layout.fragment_mkt_on_open_created, 224);
        pc.put(R.layout.deposit_card_view, 225);
        pc.put(R.layout.portfolio_balance_otn, 226);
        pc.put(R.layout.dialog_pro_trader_benefits, 227);
        pc.put(R.layout.fragment_video_education_searched_videos, 228);
        pc.put(R.layout.signal_latest_item, 229);
        pc.put(R.layout.vip_about_info, 230);
        pc.put(R.layout.fragment_promo_video, 231);
        pc.put(R.layout.chat_image_message_body_item, 232);
        pc.put(R.layout.fragment_locale_asset_search_country, 233);
        pc.put(R.layout.bg_chooser_dialog, 234);
        pc.put(R.layout.tools_content_active_tools, 235);
        pc.put(R.layout.fragment_otn_leading_board_user_board_commission, 236);
        pc.put(R.layout.digital_expiration_fragment, 237);
        pc.put(R.layout.layout_pro_trader_benefits_top_row, 238);
        pc.put(R.layout.fragment_margin_not_added, 239);
        pc.put(R.layout.dialpad_key_touchid, 240);
        pc.put(R.layout.portfolio_open_empty_item, 241);
        pc.put(R.layout.fragment_search_country, 242);
        pc.put(R.layout.right_panel_delegate_crypto_success, 243);
        pc.put(R.layout.fragment_otn_leading_board_user_board_seen, 244);
        pc.put(R.layout.fragment_balance_bar, 245);
        pc.put(R.layout.right_panel_delegate_cfd, 246);
        pc.put(R.layout.chat_fragment_search_room, 247);
        pc.put(R.layout.fragment_balance_selection, 248);
        pc.put(R.layout.macro_feed_title, 249);
        pc.put(R.layout.layout_protected_old, Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        pc.put(R.layout.fragment_vip_choose_time, 251);
        pc.put(R.layout.fragment_kyc_question_single_choice, 252);
        pc.put(R.layout.deposit_card_processing_page, 253);
        pc.put(R.layout.fragment_kyc_phone, 254);
        pc.put(R.layout.activity_chat, 255);
        pc.put(R.layout.asset_spinner_handle, 256);
        pc.put(R.layout.layout_dialog_toolbar, InputDeviceCompat.SOURCE_KEYBOARD);
        pc.put(R.layout.activity_verify_cards, 258);
        pc.put(R.layout.fragment_traderoom_settings, 259);
        pc.put(R.layout.portfolio_delegate, 260);
        pc.put(R.layout.left_menu_item_profile, 261);
        pc.put(R.layout.fragment_verify_cards, 262);
        pc.put(R.layout.portfolio_filter_options, 263);
        pc.put(R.layout.portfolio_open_header_item, 264);
        pc.put(R.layout.portfolio_page_pending_positions, 265);
        pc.put(R.layout.personal_info_dialog, 266);
        pc.put(R.layout.deposit_payment_unsuccessful_completed, 267);
        pc.put(R.layout.fragment_tutorial, 268);
        pc.put(R.layout.fragment_otn_leading_board_user_board_user, 269);
        pc.put(R.layout.dialog_trade_on_practice, 270);
        pc.put(R.layout.whats_new_dialog_spot, 271);
        pc.put(R.layout.chat_room_support_toolbar, 272);
        pc.put(R.layout.fx_whats_new_dialog, 273);
        pc.put(R.layout.fragment_withdraw_methods, 274);
        pc.put(R.layout.toolbar_black_layout, 275);
        pc.put(R.layout.portfolio_balance_cash, 276);
        pc.put(R.layout.chat_image_message_full_item, 277);
        pc.put(R.layout.chat_fragment_file_picker, 278);
        pc.put(R.layout.layout_welcome_social, 279);
        pc.put(R.layout.fragment_quiz_splash_pager_delegate, 280);
        pc.put(R.layout.fragment_room, 281);
        pc.put(R.layout.bitcoin_whats_new_dialog, 282);
        pc.put(R.layout.fragment_trial_registration, 283);
        pc.put(R.layout.push_settings_group_item, 284);
        pc.put(R.layout.withdraw_history_title_item, 285);
        pc.put(R.layout.fragment_onboardin_welcom_slide, 286);
        pc.put(R.layout.fragment_tools, 287);
        pc.put(R.layout.micro_portfolio_pending_single_group_item, 288);
        pc.put(R.layout.fragment_quiz_insights_item, 289);
        pc.put(R.layout.portfolio_pending_group_item, 290);
        pc.put(R.layout.whats_new_video_dialog, 291);
        pc.put(R.layout.fragment_quiz_insights_title_item, 292);
        pc.put(R.layout.right_panel_closed, 293);
        pc.put(R.layout.item_crypto_asset, 294);
        pc.put(R.layout.fragment_kyc_gdpr, 295);
        pc.put(R.layout.chat_file_picker_empty_item, 296);
        pc.put(R.layout.chat_room_send_layout, 297);
        pc.put(R.layout.dialog_reload_practice, 298);
        pc.put(R.layout.portfolio_delegate_macro, 299);
        pc.put(R.layout.activity_welcome_onboarding, 300);
        pc.put(R.layout.dialog_warning, MobileEvents.EVENTTYPE_USERACTION);
        pc.put(R.layout.left_menu_item_drop_down, MobileEvents.EVENTTYPE_SDKLIFECYCLE);
        pc.put(R.layout.fragment_dark_dialog, MobileEvents.EVENTTYPE_ANDROID_LIFECYCLE);
        pc.put(R.layout.toolbar_layout, MobileEvents.EVENTTYPE_RAW_TOUCH);
        pc.put(R.layout.fragment_kyc_reportable_error, MobileEvents.EVENTTYPE_EXCEPTION);
        pc.put(R.layout.fragment_deposit_methods_old, MobileEvents.EVENTTYPE_SDKPARAMETERS);
        pc.put(R.layout.account_security_phone_number_fragment, 307);
        pc.put(R.layout.right_panel_fx_delegate, 308);
        pc.put(R.layout.fragment_kyc_address, MobileEvents.EVENTTYPE_NETWORKCALL);
        pc.put(R.layout.portfolio_balances, 310);
        pc.put(R.layout.account_security_turn_on_touch_id_fragment, MobileEvents.EVENTTYPE_CUSTOMALERT);
        pc.put(R.layout.deposit_page_old, MobileEvents.EVENTTYPE_LIFENESS_INFO);
        pc.put(R.layout.fragment_kyc_document_address, 313);
        pc.put(R.layout.bottom_sheet_message, 314);
        pc.put(R.layout.left_menu_item_button, 315);
        pc.put(R.layout.tools_content_indicators, 316);
        pc.put(R.layout.deposit_page_amount_item, 317);
        pc.put(R.layout.personal_info_page, 318);
        pc.put(R.layout.right_panel_delegate_on_open_cfd, 319);
        pc.put(R.layout.fragment_quiz_error_item, 320);
        pc.put(R.layout.layout_pro_trader_benefits_bottom_row, 321);
        pc.put(R.layout.push_settings_category_item, 322);
        pc.put(R.layout.chat_empty_item, 323);
        pc.put(R.layout.right_panel_delegate_crypto, 324);
        pc.put(R.layout.chat_fragment_image_preview_slider, 325);
        pc.put(R.layout.fragment_quiz_loading_item, 326);
        pc.put(R.layout.left_menu_item_pro_trader, 327);
        pc.put(R.layout.portfolio_exp_group_item, 328);
        pc.put(R.layout.price_movements_high_frequecy_item, 329);
        pc.put(R.layout.string_basket_empty_item, 330);
        pc.put(R.layout.chat_image_message_head_item, 331);
        pc.put(R.layout.dialpad_key_zero, 332);
        pc.put(R.layout.signal_loading_item, 333);
        pc.put(R.layout.chat_file_message_full_item, 334);
        pc.put(R.layout.deposit_page, 335);
        pc.put(R.layout.chat_text_message_head_item, 336);
        pc.put(R.layout.fragment_trading_history_search_result, 337);
        pc.put(R.layout.verify_side_hint, 338);
        pc.put(R.layout.dialog_gdpr_warning, 339);
        pc.put(R.layout.dialog_otn_reward_info, 340);
        pc.put(R.layout.account_security_turn_on_2step_auth_fragment, 341);
        pc.put(R.layout.popup_window_otn_leader_board_user_details, 342);
        pc.put(R.layout.kyc_continue_button, 343);
        pc.put(R.layout.chat_loading_item, 344);
        pc.put(R.layout.portfolio_pending_header_item, 345);
        pc.put(R.layout.micro_portfolio_exp_item, 346);
        pc.put(R.layout.chat_dialog_cant_send_reason, 347);
        pc.put(R.layout.dialog_margin_add_on_info, 348);
        pc.put(R.layout.small_numpad, 349);
        pc.put(R.layout.chat_dialog_feedback, 350);
        pc.put(R.layout.selling_price_layout, 351);
        pc.put(R.layout.fragment_withdraw_complete, 352);
        pc.put(R.layout.account_security_email_confirm_fragment, 353);
        pc.put(R.layout.close_delegate, 354);
        pc.put(R.layout.fragment_room_list, 355);
        pc.put(R.layout.right_panel_delegate_crypto_confirmation, 356);
        pc.put(R.layout.fragment_kyc_phone_confirm, 357);
        pc.put(R.layout.deposit_terms_layout, 358);
        pc.put(R.layout.item_currency_selection, 359);
        pc.put(R.layout.price_movements_tittle_item, 360);
        pc.put(R.layout.fragment_quiz_off_air_delegate, 361);
        pc.put(R.layout.close_positions_item, 362);
        pc.put(R.layout.price_movements_progress, 363);
        pc.put(R.layout.menu_fragment, 364);
        pc.put(R.layout.fragment_forgot_password, 365);
        pc.put(R.layout.portfolio_cfd_item, 366);
        pc.put(R.layout.deposit_page_content_no_bonus, 367);
        pc.put(R.layout.feed_title, 368);
        pc.put(R.layout.fragment_kyc_check_box, 369);
        pc.put(R.layout.micro_portfolio_cfd_info, 370);
        pc.put(R.layout.portfolio_mkt_on_open_single_group_item, 371);
        pc.put(R.layout.price_movements_filter_menu_item, 372);
        pc.put(R.layout.micro_portfolio_cfd_single_group_item, 373);
        pc.put(R.layout.macro_smart_feed, 374);
        pc.put(R.layout.deposit_page_crypto, 375);
        pc.put(R.layout.fx_strike_item, 376);
        pc.put(R.layout.fragment_operation_search_result, 377);
        pc.put(R.layout.portfolio_delegate_micro, 378);
        pc.put(R.layout.fragment_quiz_error_delegate, 379);
        pc.put(R.layout.multi_asset_view, 380);
        pc.put(R.layout.session_main_item, 381);
        pc.put(R.layout.perform_verify_footer, 382);
        pc.put(R.layout.nps_feedback_fragment, 383);
        pc.put(R.layout.popup_window_otn_leader_board_select_country, 384);
        pc.put(R.layout.chat_item, 385);
        pc.put(R.layout.dialog_tpsl, 386);
        pc.put(R.layout.deposit_old_3ds, 387);
        pc.put(R.layout.fragment_vip_about, 388);
        pc.put(R.layout.micro_portfolio_closed_empty_item, 389);
        pc.put(R.layout.legal_update, 390);
        pc.put(R.layout.dialog_trailing_info, 391);
        pc.put(R.layout.micro_portfolio_pending_empty_item, 392);
        pc.put(R.layout.indicator_title_item, 393);
        pc.put(R.layout.top_panel, 394);
        pc.put(R.layout.operation_history_multi_selection, 395);
        pc.put(R.layout.fragment_technical_log, 396);
        pc.put(R.layout.crypto_confirm_dialog_view, 397);
        pc.put(R.layout.bottom_sheet_overnight, 398);
        pc.put(R.layout.micro_portfolio_closed_item, 399);
        pc.put(R.layout.portfolio_cfd_group_item, 400);
        pc.put(R.layout.feed_web, UnexpectedResponseException.STATUS_CODE_UNAUTHORIZED);
        pc.put(R.layout.withdraw_method_card_layout, 402);
        pc.put(R.layout.chat_fragment_image_preview, 403);
        pc.put(R.layout.macro_tweet_feed, 404);
        pc.put(R.layout.base_menu_fragment, 405);
        pc.put(R.layout.chat_load_more_item, 406);
        pc.put(R.layout.fragment_trading_history_set_date, 407);
        pc.put(R.layout.cfd_expiration_fragment, 408);
        pc.put(R.layout.deposit_page_content_no_bonus_old, 409);
        pc.put(R.layout.fragment_kyc_country, 410);
        pc.put(R.layout.left_menu_item_counter, 411);
        pc.put(R.layout.portfolio_macro_filter_item, 412);
        pc.put(R.layout.chat_user_text_message_item, 413);
        pc.put(R.layout.fragment_quiz_leaderboard_delegate, 414);
        pc.put(R.layout.fragment_otn_leading_board_user_board_date, 415);
        pc.put(R.layout.overnight_fee_item, 416);
        pc.put(R.layout.otn_history_item, 417);
        pc.put(R.layout.expiration_fragment, 418);
        pc.put(R.layout.otn_leader_board_item, 419);
        pc.put(R.layout.template_item, 420);
        pc.put(R.layout.chat_rate_message_item, 421);
        pc.put(R.layout.dialpad_key, 422);
        pc.put(R.layout.feed_bottom_panel, 423);
        pc.put(R.layout.portfolio_pending_info, 424);
        pc.put(R.layout.otn_leader_board_first_item, 425);
        pc.put(R.layout.fragment_push_settings, 426);
        pc.put(R.layout.trailing_whats_new_dialog, 427);
        pc.put(R.layout.dialpad_key_back, 428);
        pc.put(R.layout.micro_portfolio_page_pending_positions, 429);
        pc.put(R.layout.fragment_kyc_block, 430);
        pc.put(R.layout.fragment_withdraw_verify, 431);
        pc.put(R.layout.fragment_account_security, 432);
        pc.put(R.layout.fragment_withdraw_history, 433);
        pc.put(R.layout.account_security_confirmed_phone_fragment, 434);
        pc.put(R.layout.chat_user_file_message_item, 435);
        pc.put(R.layout.portfolio_cfd_single_group_item, 436);
        pc.put(R.layout.signal_title_item, 437);
        pc.put(R.layout.verify_side_item, 438);
        pc.put(R.layout.left_menu_item_button_grayed, 439);
        pc.put(R.layout.ichimoku_dialog, 440);
        pc.put(R.layout.chat_file_message_body_item, 441);
        pc.put(R.layout.fragment_kyc_question_yes_no, 442);
        pc.put(R.layout.iqkeyboard_fragment, 443);
        pc.put(R.layout.whats_new_dialog, 444);
        pc.put(R.layout.micro_portfolio_mkt_on_open_item, 445);
        pc.put(R.layout.fragment_welcome_registration, 446);
        pc.put(R.layout.fragment_kyc_question_warning2, 447);
        pc.put(R.layout.micro_portfolio_exp_info, 448);
        pc.put(R.layout.account_security_confirmed_email_fragment, 449);
        pc.put(R.layout.bottom_sheet_item, 450);
        pc.put(R.layout.fragment_quiz_promocode_delegate, 451);
        pc.put(R.layout.micro_portfolio_pending_group_item, 452);
        pc.put(R.layout.macro_article_feed, 453);
        pc.put(R.layout.dialog_margin_add_on_position, 454);
        pc.put(R.layout.fragment_otn_leading_board_profile, 455);
        pc.put(R.layout.chat_suggestion_message_item, 456);
        pc.put(R.layout.gif_whats_new_dialog, 457);
        pc.put(R.layout.layout_amount_selector_collapsed, 458);
        pc.put(R.layout.fragment_market_is_open, 459);
        pc.put(R.layout.dialog_closed_deals_header_list_cfd, 460);
        pc.put(R.layout.deposit_constructor_view, 461);
        pc.put(R.layout.account_security_confirm_phone_fragment, 462);
        pc.put(R.layout.popup_window_currency_selection, 463);
        pc.put(R.layout.fragment_quiz_leaderboard_you_item, 464);
        pc.put(R.layout.withdraw_insufficient_founds_layout, 465);
        pc.put(R.layout.chat_dialog_message_options, 466);
        pc.put(R.layout.open_binary_option_item, 467);
        pc.put(R.layout.activity_pro_trader_web, 468);
        pc.put(R.layout.right_panel_delegate_cfd_on_open_main, 469);
        pc.put(R.layout.micro_portfolio_exp_single_group_item, 470);
        pc.put(R.layout.deposit_payment_authorization_page, 471);
        pc.put(R.layout.view_pager_whats_new_dialog, 472);
        pc.put(R.layout.sell_delegate, 473);
        pc.put(R.layout.position_item_title_layout, 474);
        pc.put(R.layout.fragment_quiz_on_air_delegate, 475);
        pc.put(R.layout.fragment_pending_chooser, 476);
        pc.put(R.layout.chat_text_message_tail_item, 477);
        pc.put(R.layout.fragment_quiz_insights_delegate, 478);
        pc.put(R.layout.fragment_otn_leading_board_user_board_place, 479);
        pc.put(R.layout.right_panel_delegate_turbo_binary, 480);
        pc.put(R.layout.online_counter_layout, 481);
        pc.put(R.layout.fragment_vip_education, 482);
        pc.put(R.layout.left_menu_item_notification, 483);
        pc.put(R.layout.otn_leader_board_select_country_item, 484);
        pc.put(R.layout.whats_new_deposit_item, 485);
        pc.put(R.layout.fragment_pro_trader_web, 486);
        pc.put(R.layout.micro_bottom_panel, 487);
        pc.put(R.layout.video_education_tag_item, 488);
        pc.put(R.layout.chat_dialog_user_info, 489);
        pc.put(R.layout.right_panel_delegate_crypto_loading, 490);
        pc.put(R.layout.item_payment_method_old, 491);
        pc.put(R.layout.video_education_category_item, 492);
        pc.put(R.layout.right_panel_delegate_spot, 493);
        pc.put(R.layout.fragment_quiz, 494);
        pc.put(R.layout.fragment_account_security_page, 495);
        pc.put(R.layout.deposit_currency_item, 496);
        pc.put(R.layout.dialog_multiplier_confirm, 497);
        pc.put(R.layout.left_menu_item_snippet, 498);
        pc.put(R.layout.fragment_kyc_sex, 499);
        pc.put(R.layout.activity_pending_removal, 500);
        pc.put(R.layout.open_crypto_item, 501);
        pc.put(R.layout.price_movements_item, 502);
        pc.put(R.layout.deposit_card_front_side, 503);
        pc.put(R.layout.verify_card_item, 504);
        pc.put(R.layout.chat_file_message_tail_item, 505);
        pc.put(R.layout.template_instrument_item, 506);
        pc.put(R.layout.chat_micro_item, 507);
        pc.put(R.layout.vip_education_session_item, 508);
        pc.put(R.layout.left_menu_item_child, 509);
        pc.put(R.layout.dialog_closed_deals_header_do, 510);
        pc.put(R.layout.asset_fragment, FrameMetricsAggregator.EVERY_DURATION);
    }

    /*  JADX ERROR: JadxOverflowException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Iterative traversal limit reached, method: com.iqoption.a.getDataBinder(android.databinding.DataBindingComponent, android.view.View, int):android.databinding.ViewDataBinding
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:48)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:82)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:29)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent r4, android.view.View r5, int r6) {
        /*
        r3 = this;
        r0 = pc;
        r6 = r0.get(r6);
        if (r6 <= 0) goto L_0x4aff;
    L_0x0008:
        r0 = r5.getTag();
        if (r0 != 0) goto L_0x0017;
    L_0x000e:
        r4 = new java.lang.RuntimeException;
        r5 = "view must have a tag";
        r4.<init>(r5);
        throw r4;
    L_0x0017:
        r1 = 0;
        r2 = 1;
        switch(r6) {
            case 1: goto L_0x4ada;
            case 2: goto L_0x4ab5;
            case 3: goto L_0x4a82;
            case 4: goto L_0x4a5d;
            case 5: goto L_0x4a38;
            case 6: goto L_0x4a13;
            case 7: goto L_0x49e0;
            case 8: goto L_0x49bb;
            case 9: goto L_0x4996;
            case 10: goto L_0x4971;
            case 11: goto L_0x4948;
            case 12: goto L_0x4923;
            case 13: goto L_0x48fe;
            case 14: goto L_0x48d9;
            case 15: goto L_0x48b4;
            case 16: goto L_0x488f;
            case 17: goto L_0x486a;
            case 18: goto L_0x4845;
            case 19: goto L_0x4820;
            case 20: goto L_0x47fb;
            case 21: goto L_0x47d6;
            case 22: goto L_0x47b1;
            case 23: goto L_0x478c;
            case 24: goto L_0x4767;
            case 25: goto L_0x4742;
            case 26: goto L_0x470f;
            case 27: goto L_0x46ea;
            case 28: goto L_0x46c5;
            case 29: goto L_0x46a0;
            case 30: goto L_0x467b;
            case 31: goto L_0x4656;
            case 32: goto L_0x4631;
            case 33: goto L_0x460c;
            case 34: goto L_0x45e7;
            case 35: goto L_0x45c2;
            case 36: goto L_0x459d;
            case 37: goto L_0x4578;
            case 38: goto L_0x4553;
            case 39: goto L_0x452e;
            case 40: goto L_0x4509;
            case 41: goto L_0x44e4;
            case 42: goto L_0x44bf;
            case 43: goto L_0x449a;
            case 44: goto L_0x4475;
            case 45: goto L_0x4450;
            case 46: goto L_0x442b;
            case 47: goto L_0x4406;
            case 48: goto L_0x43e1;
            case 49: goto L_0x43bc;
            case 50: goto L_0x4397;
            case 51: goto L_0x4364;
            case 52: goto L_0x433f;
            case 53: goto L_0x431a;
            case 54: goto L_0x42f5;
            case 55: goto L_0x42cc;
            case 56: goto L_0x42a7;
            case 57: goto L_0x4282;
            case 58: goto L_0x425d;
            case 59: goto L_0x4238;
            case 60: goto L_0x4213;
            case 61: goto L_0x41ee;
            case 62: goto L_0x41c9;
            case 63: goto L_0x41a4;
            case 64: goto L_0x417f;
            case 65: goto L_0x415a;
            case 66: goto L_0x4135;
            case 67: goto L_0x4110;
            case 68: goto L_0x40eb;
            case 69: goto L_0x40c6;
            case 70: goto L_0x40a1;
            case 71: goto L_0x406e;
            case 72: goto L_0x4049;
            case 73: goto L_0x4024;
            case 74: goto L_0x3fff;
            case 75: goto L_0x3fda;
            case 76: goto L_0x3fb5;
            case 77: goto L_0x3f90;
            case 78: goto L_0x3f6b;
            case 79: goto L_0x3f46;
            case 80: goto L_0x3f21;
            case 81: goto L_0x3efc;
            case 82: goto L_0x3ed7;
            case 83: goto L_0x3eb2;
            case 84: goto L_0x3e8d;
            case 85: goto L_0x3e68;
            case 86: goto L_0x3e43;
            case 87: goto L_0x3e1e;
            case 88: goto L_0x3df9;
            case 89: goto L_0x3dd4;
            case 90: goto L_0x3daf;
            case 91: goto L_0x3d8a;
            case 92: goto L_0x3d65;
            case 93: goto L_0x3d40;
            case 94: goto L_0x3d1b;
            case 95: goto L_0x3cf6;
            case 96: goto L_0x3cd1;
            case 97: goto L_0x3cac;
            case 98: goto L_0x3c87;
            case 99: goto L_0x3c62;
            case 100: goto L_0x3c3d;
            case 101: goto L_0x3c18;
            case 102: goto L_0x3bf3;
            case 103: goto L_0x3bce;
            case 104: goto L_0x3ba9;
            case 105: goto L_0x3b84;
            case 106: goto L_0x3b5f;
            case 107: goto L_0x3b3a;
            case 108: goto L_0x3b15;
            case 109: goto L_0x3af0;
            case 110: goto L_0x3acb;
            case 111: goto L_0x3aa6;
            case 112: goto L_0x3a81;
            case 113: goto L_0x3a5c;
            case 114: goto L_0x3a29;
            case 115: goto L_0x3a04;
            case 116: goto L_0x39df;
            case 117: goto L_0x39ba;
            case 118: goto L_0x3987;
            case 119: goto L_0x3962;
            case 120: goto L_0x393d;
            case 121: goto L_0x3918;
            case 122: goto L_0x38f3;
            case 123: goto L_0x38ce;
            case 124: goto L_0x38a9;
            case 125: goto L_0x3884;
            case 126: goto L_0x385f;
            case 127: goto L_0x383a;
            case 128: goto L_0x3815;
            case 129: goto L_0x37f0;
            case 130: goto L_0x37cb;
            case 131: goto L_0x37a6;
            case 132: goto L_0x3781;
            case 133: goto L_0x375c;
            case 134: goto L_0x3737;
            case 135: goto L_0x3712;
            case 136: goto L_0x36ed;
            case 137: goto L_0x36c8;
            case 138: goto L_0x36a3;
            case 139: goto L_0x367e;
            case 140: goto L_0x3659;
            case 141: goto L_0x3634;
            case 142: goto L_0x360f;
            case 143: goto L_0x35ea;
            case 144: goto L_0x35c5;
            case 145: goto L_0x35a0;
            case 146: goto L_0x357b;
            case 147: goto L_0x3556;
            case 148: goto L_0x3531;
            case 149: goto L_0x350c;
            case 150: goto L_0x34e7;
            case 151: goto L_0x34c2;
            case 152: goto L_0x349d;
            case 153: goto L_0x3478;
            case 154: goto L_0x3453;
            case 155: goto L_0x342e;
            case 156: goto L_0x3409;
            case 157: goto L_0x33e4;
            case 158: goto L_0x33bf;
            case 159: goto L_0x339a;
            case 160: goto L_0x3375;
            case 161: goto L_0x3350;
            case 162: goto L_0x332b;
            case 163: goto L_0x3306;
            case 164: goto L_0x32e1;
            case 165: goto L_0x32bc;
            case 166: goto L_0x3297;
            case 167: goto L_0x3272;
            case 168: goto L_0x324d;
            case 169: goto L_0x3228;
            case 170: goto L_0x3203;
            case 171: goto L_0x31de;
            case 172: goto L_0x31b9;
            case 173: goto L_0x3194;
            case 174: goto L_0x316f;
            case 175: goto L_0x313c;
            case 176: goto L_0x3117;
            case 177: goto L_0x30ee;
            case 178: goto L_0x30bb;
            case 179: goto L_0x3096;
            case 180: goto L_0x3071;
            case 181: goto L_0x304c;
            case 182: goto L_0x3027;
            case 183: goto L_0x3002;
            case 184: goto L_0x2fdd;
            case 185: goto L_0x2fb8;
            case 186: goto L_0x2f93;
            case 187: goto L_0x2f6e;
            case 188: goto L_0x2f49;
            case 189: goto L_0x2f24;
            case 190: goto L_0x2eff;
            case 191: goto L_0x2eda;
            case 192: goto L_0x2eb5;
            case 193: goto L_0x2e90;
            case 194: goto L_0x2e6b;
            case 195: goto L_0x2e46;
            case 196: goto L_0x2e21;
            case 197: goto L_0x2dfc;
            case 198: goto L_0x2dd7;
            case 199: goto L_0x2db2;
            case 200: goto L_0x2d8d;
            case 201: goto L_0x2d68;
            case 202: goto L_0x2d43;
            case 203: goto L_0x2d1e;
            case 204: goto L_0x2cf9;
            case 205: goto L_0x2cd4;
            case 206: goto L_0x2caf;
            case 207: goto L_0x2c8a;
            case 208: goto L_0x2c65;
            case 209: goto L_0x2c40;
            case 210: goto L_0x2c1b;
            case 211: goto L_0x2bf6;
            case 212: goto L_0x2bd1;
            case 213: goto L_0x2bac;
            case 214: goto L_0x2b87;
            case 215: goto L_0x2b62;
            case 216: goto L_0x2b3d;
            case 217: goto L_0x2b0a;
            case 218: goto L_0x2ae5;
            case 219: goto L_0x2ac0;
            case 220: goto L_0x2a9b;
            case 221: goto L_0x2a76;
            case 222: goto L_0x2a51;
            case 223: goto L_0x2a2c;
            case 224: goto L_0x2a07;
            case 225: goto L_0x29e2;
            case 226: goto L_0x29bd;
            case 227: goto L_0x2998;
            case 228: goto L_0x2973;
            case 229: goto L_0x294e;
            case 230: goto L_0x2929;
            case 231: goto L_0x2904;
            case 232: goto L_0x28df;
            case 233: goto L_0x28ba;
            case 234: goto L_0x2895;
            case 235: goto L_0x2870;
            case 236: goto L_0x284b;
            case 237: goto L_0x2826;
            case 238: goto L_0x2801;
            case 239: goto L_0x27dc;
            case 240: goto L_0x27b7;
            case 241: goto L_0x2792;
            case 242: goto L_0x276d;
            case 243: goto L_0x2748;
            case 244: goto L_0x2723;
            case 245: goto L_0x26fe;
            case 246: goto L_0x26d9;
            case 247: goto L_0x26b4;
            case 248: goto L_0x2681;
            case 249: goto L_0x265c;
            case 250: goto L_0x2637;
            case 251: goto L_0x2612;
            case 252: goto L_0x25ed;
            case 253: goto L_0x25c8;
            case 254: goto L_0x25a3;
            case 255: goto L_0x257e;
            case 256: goto L_0x2559;
            case 257: goto L_0x2534;
            case 258: goto L_0x250f;
            case 259: goto L_0x24ea;
            case 260: goto L_0x24b7;
            case 261: goto L_0x2492;
            case 262: goto L_0x246d;
            case 263: goto L_0x2448;
            case 264: goto L_0x2423;
            case 265: goto L_0x23fe;
            case 266: goto L_0x23d9;
            case 267: goto L_0x23b4;
            case 268: goto L_0x238f;
            case 269: goto L_0x236a;
            case 270: goto L_0x2345;
            case 271: goto L_0x2320;
            case 272: goto L_0x22ed;
            case 273: goto L_0x22c8;
            case 274: goto L_0x22a3;
            case 275: goto L_0x227e;
            case 276: goto L_0x2259;
            case 277: goto L_0x2234;
            case 278: goto L_0x220f;
            case 279: goto L_0x21dc;
            case 280: goto L_0x21b7;
            case 281: goto L_0x2192;
            case 282: goto L_0x216d;
            case 283: goto L_0x2148;
            case 284: goto L_0x2123;
            case 285: goto L_0x20fe;
            case 286: goto L_0x20cb;
            case 287: goto L_0x20a6;
            case 288: goto L_0x2081;
            case 289: goto L_0x205c;
            case 290: goto L_0x2037;
            case 291: goto L_0x2012;
            case 292: goto L_0x1fed;
            case 293: goto L_0x1fc8;
            case 294: goto L_0x1fa3;
            case 295: goto L_0x1f7e;
            case 296: goto L_0x1f59;
            case 297: goto L_0x1f34;
            case 298: goto L_0x1f0f;
            case 299: goto L_0x1eea;
            case 300: goto L_0x1ec5;
            case 301: goto L_0x1ea0;
            case 302: goto L_0x1e7b;
            case 303: goto L_0x1e56;
            case 304: goto L_0x1e31;
            case 305: goto L_0x1e0c;
            case 306: goto L_0x1de7;
            case 307: goto L_0x1dc2;
            case 308: goto L_0x1d9d;
            case 309: goto L_0x1d78;
            case 310: goto L_0x1d53;
            case 311: goto L_0x1d2e;
            case 312: goto L_0x1d09;
            case 313: goto L_0x1ce4;
            case 314: goto L_0x1cbf;
            case 315: goto L_0x1c9a;
            case 316: goto L_0x1c75;
            case 317: goto L_0x1c50;
            case 318: goto L_0x1c2b;
            case 319: goto L_0x1c06;
            case 320: goto L_0x1be1;
            case 321: goto L_0x1bbc;
            case 322: goto L_0x1b97;
            case 323: goto L_0x1b72;
            case 324: goto L_0x1b4d;
            case 325: goto L_0x1b28;
            case 326: goto L_0x1b03;
            case 327: goto L_0x1ade;
            case 328: goto L_0x1ab9;
            case 329: goto L_0x1a94;
            case 330: goto L_0x1a6f;
            case 331: goto L_0x1a4a;
            case 332: goto L_0x1a25;
            case 333: goto L_0x1a00;
            case 334: goto L_0x19db;
            case 335: goto L_0x19b6;
            case 336: goto L_0x1991;
            case 337: goto L_0x196c;
            case 338: goto L_0x1947;
            case 339: goto L_0x1922;
            case 340: goto L_0x18fd;
            case 341: goto L_0x18d8;
            case 342: goto L_0x18b3;
            case 343: goto L_0x188e;
            case 344: goto L_0x1869;
            case 345: goto L_0x1844;
            case 346: goto L_0x181f;
            case 347: goto L_0x17fa;
            case 348: goto L_0x17d5;
            case 349: goto L_0x17b0;
            case 350: goto L_0x178b;
            case 351: goto L_0x1766;
            case 352: goto L_0x1741;
            case 353: goto L_0x171c;
            case 354: goto L_0x16f7;
            case 355: goto L_0x16d2;
            case 356: goto L_0x16ad;
            case 357: goto L_0x1688;
            case 358: goto L_0x1663;
            case 359: goto L_0x163e;
            case 360: goto L_0x1619;
            case 361: goto L_0x15f4;
            case 362: goto L_0x15cf;
            case 363: goto L_0x15aa;
            case 364: goto L_0x1585;
            case 365: goto L_0x1552;
            case 366: goto L_0x152d;
            case 367: goto L_0x1508;
            case 368: goto L_0x14df;
            case 369: goto L_0x14ba;
            case 370: goto L_0x1495;
            case 371: goto L_0x1470;
            case 372: goto L_0x144b;
            case 373: goto L_0x1426;
            case 374: goto L_0x1401;
            case 375: goto L_0x13dc;
            case 376: goto L_0x13b7;
            case 377: goto L_0x1384;
            case 378: goto L_0x135f;
            case 379: goto L_0x133a;
            case 380: goto L_0x1315;
            case 381: goto L_0x12f0;
            case 382: goto L_0x12cb;
            case 383: goto L_0x12a6;
            case 384: goto L_0x1281;
            case 385: goto L_0x125c;
            case 386: goto L_0x1237;
            case 387: goto L_0x1212;
            case 388: goto L_0x11ed;
            case 389: goto L_0x11c8;
            case 390: goto L_0x11a3;
            case 391: goto L_0x117e;
            case 392: goto L_0x1159;
            case 393: goto L_0x1134;
            case 394: goto L_0x110f;
            case 395: goto L_0x10ea;
            case 396: goto L_0x10c5;
            case 397: goto L_0x109c;
            case 398: goto L_0x1077;
            case 399: goto L_0x1052;
            case 400: goto L_0x102d;
            case 401: goto L_0x1008;
            case 402: goto L_0x0fe3;
            case 403: goto L_0x0fbe;
            case 404: goto L_0x0f99;
            case 405: goto L_0x0f74;
            case 406: goto L_0x0f4f;
            case 407: goto L_0x0f2a;
            case 408: goto L_0x0f05;
            case 409: goto L_0x0ee0;
            case 410: goto L_0x0ebb;
            case 411: goto L_0x0e96;
            case 412: goto L_0x0e71;
            case 413: goto L_0x0e4c;
            case 414: goto L_0x0e27;
            case 415: goto L_0x0e02;
            case 416: goto L_0x0ddd;
            case 417: goto L_0x0db8;
            case 418: goto L_0x0d93;
            case 419: goto L_0x0d6e;
            case 420: goto L_0x0d49;
            case 421: goto L_0x0d24;
            case 422: goto L_0x0cff;
            case 423: goto L_0x0cd6;
            case 424: goto L_0x0cb1;
            case 425: goto L_0x0c8c;
            case 426: goto L_0x0c67;
            case 427: goto L_0x0c42;
            case 428: goto L_0x0c1d;
            case 429: goto L_0x0bf8;
            case 430: goto L_0x0bd3;
            case 431: goto L_0x0bae;
            case 432: goto L_0x0b89;
            case 433: goto L_0x0b64;
            case 434: goto L_0x0b3f;
            case 435: goto L_0x0b1a;
            case 436: goto L_0x0af5;
            case 437: goto L_0x0ad0;
            case 438: goto L_0x0aab;
            case 439: goto L_0x0a86;
            case 440: goto L_0x0a61;
            case 441: goto L_0x0a3c;
            case 442: goto L_0x0a17;
            case 443: goto L_0x09f2;
            case 444: goto L_0x09cd;
            case 445: goto L_0x09a8;
            case 446: goto L_0x0983;
            case 447: goto L_0x095e;
            case 448: goto L_0x0939;
            case 449: goto L_0x0914;
            case 450: goto L_0x08ef;
            case 451: goto L_0x08ca;
            case 452: goto L_0x08a5;
            case 453: goto L_0x0880;
            case 454: goto L_0x085b;
            case 455: goto L_0x0836;
            case 456: goto L_0x0811;
            case 457: goto L_0x07ec;
            case 458: goto L_0x07c7;
            case 459: goto L_0x07a2;
            case 460: goto L_0x077d;
            case 461: goto L_0x0758;
            case 462: goto L_0x0733;
            case 463: goto L_0x070e;
            case 464: goto L_0x06e9;
            case 465: goto L_0x06c4;
            case 466: goto L_0x069f;
            case 467: goto L_0x067a;
            case 468: goto L_0x0655;
            case 469: goto L_0x0630;
            case 470: goto L_0x060b;
            case 471: goto L_0x05e6;
            case 472: goto L_0x05c1;
            case 473: goto L_0x059c;
            case 474: goto L_0x0577;
            case 475: goto L_0x0552;
            case 476: goto L_0x052d;
            case 477: goto L_0x0508;
            case 478: goto L_0x04e3;
            case 479: goto L_0x04be;
            case 480: goto L_0x0499;
            case 481: goto L_0x0474;
            case 482: goto L_0x044f;
            case 483: goto L_0x042a;
            case 484: goto L_0x0405;
            case 485: goto L_0x03e0;
            case 486: goto L_0x03bb;
            case 487: goto L_0x0396;
            case 488: goto L_0x0371;
            case 489: goto L_0x034c;
            case 490: goto L_0x0327;
            case 491: goto L_0x0302;
            case 492: goto L_0x02dd;
            case 493: goto L_0x02b8;
            case 494: goto L_0x0293;
            case 495: goto L_0x026e;
            case 496: goto L_0x0249;
            case 497: goto L_0x0224;
            case 498: goto L_0x01ff;
            case 499: goto L_0x01da;
            case 500: goto L_0x01b5;
            case 501: goto L_0x0190;
            case 502: goto L_0x016b;
            case 503: goto L_0x0146;
            case 504: goto L_0x0121;
            case 505: goto L_0x00fc;
            case 506: goto L_0x00d7;
            case 507: goto L_0x00b2;
            case 508: goto L_0x008d;
            case 509: goto L_0x0068;
            case 510: goto L_0x0043;
            case 511: goto L_0x001e;
            default: goto L_0x001c;
        };
    L_0x001c:
        goto L_0x4aff;
    L_0x001e:
        r6 = "layout/asset_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x002c;
    L_0x0026:
        r6 = new com.iqoption.d.aq;
        r6.<init>(r4, r5);
        return r6;
    L_0x002c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for asset_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0043:
        r6 = "layout/dialog_closed_deals_header_do_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0051;
    L_0x004b:
        r6 = new com.iqoption.d.hs;
        r6.<init>(r4, r5);
        return r6;
    L_0x0051:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_closed_deals_header_do is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0068:
        r6 = "layout/left_menu_item_child_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0076;
    L_0x0070:
        r6 = new com.iqoption.d.xp;
        r6.<init>(r4, r5);
        return r6;
    L_0x0076:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item_child is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x008d:
        r6 = "layout/vip_education_session_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x009b;
    L_0x0095:
        r6 = new com.iqoption.d.alx;
        r6.<init>(r4, r5);
        return r6;
    L_0x009b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for vip_education_session_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x00b2:
        r6 = "layout/chat_micro_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x00c0;
    L_0x00ba:
        r6 = new com.iqoption.d.dx;
        r6.<init>(r4, r5);
        return r6;
    L_0x00c0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_micro_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x00d7:
        r6 = "layout/template_instrument_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x00e5;
    L_0x00df:
        r6 = new com.iqoption.d.akf;
        r6.<init>(r4, r5);
        return r6;
    L_0x00e5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for template_instrument_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x00fc:
        r6 = "layout/chat_file_message_tail_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x010a;
    L_0x0104:
        r6 = new com.iqoption.d.cr;
        r6.<init>(r4, r5);
        return r6;
    L_0x010a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_file_message_tail_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0121:
        r6 = "layout/verify_card_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x012f;
    L_0x0129:
        r6 = new com.iqoption.d.alb;
        r6.<init>(r4, r5);
        return r6;
    L_0x012f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for verify_card_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0146:
        r6 = "layout/deposit_card_front_side_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0154;
    L_0x014e:
        r6 = new com.iqoption.d.fx;
        r6.<init>(r4, r5);
        return r6;
    L_0x0154:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_card_front_side is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x016b:
        r6 = "layout/price_movements_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0179;
    L_0x0173:
        r6 = new com.iqoption.d.agx;
        r6.<init>(r4, r5);
        return r6;
    L_0x0179:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for price_movements_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0190:
        r6 = "layout/open_crypto_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x019e;
    L_0x0198:
        r6 = new com.iqoption.d.ach;
        r6.<init>(r4, r5);
        return r6;
    L_0x019e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for open_crypto_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x01b5:
        r6 = "layout/activity_pending_removal_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x01c3;
    L_0x01bd:
        r6 = new com.iqoption.d.ae;
        r6.<init>(r4, r5);
        return r6;
    L_0x01c3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for activity_pending_removal is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x01da:
        r6 = "layout/fragment_kyc_sex_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x01e8;
    L_0x01e2:
        r6 = new com.iqoption.d.oe;
        r6.<init>(r4, r5);
        return r6;
    L_0x01e8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_sex is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x01ff:
        r6 = "layout/left_menu_item_snippet_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x020d;
    L_0x0207:
        r6 = new com.iqoption.d.yd;
        r6.<init>(r4, r5);
        return r6;
    L_0x020d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item_snippet is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0224:
        r6 = "layout/dialog_multiplier_confirm_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0232;
    L_0x022c:
        r6 = new com.iqoption.d.iu;
        r6.<init>(r4, r5);
        return r6;
    L_0x0232:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_multiplier_confirm is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0249:
        r6 = "layout/deposit_currency_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0257;
    L_0x0251:
        r6 = new com.iqoption.d.gh;
        r6.<init>(r4, r5);
        return r6;
    L_0x0257:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_currency_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x026e:
        r6 = "layout/fragment_account_security_page_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x027c;
    L_0x0276:
        r6 = new com.iqoption.d.lc;
        r6.<init>(r4, r5);
        return r6;
    L_0x027c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_account_security_page is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0293:
        r6 = "layout/fragment_quiz_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x02a1;
    L_0x029b:
        r6 = new com.iqoption.d.qo;
        r6.<init>(r4, r5);
        return r6;
    L_0x02a1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x02b8:
        r6 = "layout/right_panel_delegate_spot_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x02c6;
    L_0x02c0:
        r6 = new com.iqoption.d.ain;
        r6.<init>(r4, r5);
        return r6;
    L_0x02c6:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_spot is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x02dd:
        r6 = "layout/video_education_category_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x02eb;
    L_0x02e5:
        r6 = new com.iqoption.d.alh;
        r6.<init>(r4, r5);
        return r6;
    L_0x02eb:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for video_education_category_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0302:
        r6 = "layout/item_payment_method_old_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0310;
    L_0x030a:
        r6 = new com.iqoption.d.wi;
        r6.<init>(r4, r5);
        return r6;
    L_0x0310:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for item_payment_method_old is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0327:
        r6 = "layout/right_panel_delegate_crypto_loading_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0335;
    L_0x032f:
        r6 = new com.iqoption.d.aib;
        r6.<init>(r4, r5);
        return r6;
    L_0x0335:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_crypto_loading is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x034c:
        r6 = "layout/chat_dialog_user_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x035a;
    L_0x0354:
        r6 = new com.iqoption.d.ch;
        r6.<init>(r4, r5);
        return r6;
    L_0x035a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_dialog_user_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0371:
        r6 = "layout/video_education_tag_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x037f;
    L_0x0379:
        r6 = new com.iqoption.d.aln;
        r6.<init>(r4, r5);
        return r6;
    L_0x037f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for video_education_tag_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0396:
        r6 = "layout/micro_bottom_panel_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x03a4;
    L_0x039e:
        r6 = new com.iqoption.d.zd;
        r6.<init>(r4, r5);
        return r6;
    L_0x03a4:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_bottom_panel is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x03bb:
        r6 = "layout/fragment_pro_trader_web_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x03c9;
    L_0x03c3:
        r6 = new com.iqoption.d.qi;
        r6.<init>(r4, r5);
        return r6;
    L_0x03c9:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_pro_trader_web is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x03e0:
        r6 = "layout/whats_new_deposit_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x03ee;
    L_0x03e8:
        r6 = new com.iqoption.d.alz;
        r6.<init>(r4, r5);
        return r6;
    L_0x03ee:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for whats_new_deposit_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0405:
        r6 = "layout/otn_leader_board_select_country_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0413;
    L_0x040d:
        r6 = new com.iqoption.d.adb;
        r6.<init>(r4, r5);
        return r6;
    L_0x0413:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for otn_leader_board_select_country_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x042a:
        r6 = "layout/left_menu_item_notification_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0438;
    L_0x0432:
        r6 = new com.iqoption.d.xx;
        r6.<init>(r4, r5);
        return r6;
    L_0x0438:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item_notification is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x044f:
        r6 = "layout/fragment_vip_education_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x045d;
    L_0x0457:
        r6 = new com.iqoption.d.ty;
        r6.<init>(r4, r5);
        return r6;
    L_0x045d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_vip_education is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0474:
        r6 = "layout/online_counter_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0482;
    L_0x047c:
        r6 = new com.iqoption.d.abx;
        r6.<init>(r4, r5);
        return r6;
    L_0x0482:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for online_counter_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0499:
        r6 = "layout/right_panel_delegate_turbo_binary_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x04a7;
    L_0x04a1:
        r6 = new com.iqoption.d.aip;
        r6.<init>(r4, r5);
        return r6;
    L_0x04a7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_turbo_binary is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x04be:
        r6 = "layout/fragment_otn_leading_board_user_board_place_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x04cc;
    L_0x04c6:
        r6 = new com.iqoption.d.ps;
        r6.<init>(r4, r5);
        return r6;
    L_0x04cc:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_otn_leading_board_user_board_place is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x04e3:
        r6 = "layout/fragment_quiz_insights_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x04f1;
    L_0x04eb:
        r6 = new com.iqoption.d.qu;
        r6.<init>(r4, r5);
        return r6;
    L_0x04f1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_insights_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0508:
        r6 = "layout/chat_text_message_tail_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0516;
    L_0x0510:
        r6 = new com.iqoption.d.ev;
        r6.<init>(r4, r5);
        return r6;
    L_0x0516:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_text_message_tail_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x052d:
        r6 = "layout/fragment_pending_chooser_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x053b;
    L_0x0535:
        r6 = new com.iqoption.d.qa;
        r6.<init>(r4, r5);
        return r6;
    L_0x053b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_pending_chooser is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0552:
        r6 = "layout/fragment_quiz_on_air_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0560;
    L_0x055a:
        r6 = new com.iqoption.d.ro;
        r6.<init>(r4, r5);
        return r6;
    L_0x0560:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_on_air_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0577:
        r6 = "layout/position_item_title_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0585;
    L_0x057f:
        r6 = new com.iqoption.d.agh;
        r6.<init>(r4, r5);
        return r6;
    L_0x0585:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for position_item_title_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x059c:
        r6 = "layout/sell_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x05aa;
    L_0x05a4:
        r6 = new com.iqoption.d.aiv;
        r6.<init>(r4, r5);
        return r6;
    L_0x05aa:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for sell_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x05c1:
        r6 = "layout/view_pager_whats_new_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x05cf;
    L_0x05c9:
        r6 = new com.iqoption.d.alr;
        r6.<init>(r4, r5);
        return r6;
    L_0x05cf:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for view_pager_whats_new_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x05e6:
        r6 = "layout/deposit_payment_authorization_page_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x05f4;
    L_0x05ee:
        r6 = new com.iqoption.d.hc;
        r6.<init>(r4, r5);
        return r6;
    L_0x05f4:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_payment_authorization_page is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x060b:
        r6 = "layout/micro_portfolio_exp_single_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0619;
    L_0x0613:
        r6 = new com.iqoption.d.aad;
        r6.<init>(r4, r5);
        return r6;
    L_0x0619:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_exp_single_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0630:
        r6 = "layout/right_panel_delegate_cfd_on_open_main_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x063e;
    L_0x0638:
        r6 = new com.iqoption.d.aht;
        r6.<init>(r4, r5);
        return r6;
    L_0x063e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_cfd_on_open_main is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0655:
        r6 = "layout/activity_pro_trader_web_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0663;
    L_0x065d:
        r6 = new com.iqoption.d.ai;
        r6.<init>(r4, r5);
        return r6;
    L_0x0663:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for activity_pro_trader_web is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x067a:
        r6 = "layout/open_binary_option_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0688;
    L_0x0682:
        r6 = new com.iqoption.d.acb;
        r6.<init>(r4, r5);
        return r6;
    L_0x0688:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for open_binary_option_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x069f:
        r6 = "layout/chat_dialog_message_options_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x06ad;
    L_0x06a7:
        r6 = new com.iqoption.d.cf;
        r6.<init>(r4, r5);
        return r6;
    L_0x06ad:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_dialog_message_options is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x06c4:
        r6 = "layout/withdraw_insufficient_founds_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x06d2;
    L_0x06cc:
        r6 = new com.iqoption.d.ams;
        r6.<init>(r4, r5);
        return r6;
    L_0x06d2:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for withdraw_insufficient_founds_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x06e9:
        r6 = "layout/fragment_quiz_leaderboard_you_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x06f7;
    L_0x06f1:
        r6 = new com.iqoption.d.rg;
        r6.<init>(r4, r5);
        return r6;
    L_0x06f7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_leaderboard_you_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x070e:
        r6 = "layout/popup_window_currency_selection_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x071c;
    L_0x0716:
        r6 = new com.iqoption.d.adl;
        r6.<init>(r4, r5);
        return r6;
    L_0x071c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for popup_window_currency_selection is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0733:
        r6 = "layout/account_security_confirm_phone_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0741;
    L_0x073b:
        r6 = new com.iqoption.d.h;
        r6.<init>(r4, r5);
        return r6;
    L_0x0741:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for account_security_confirm_phone_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0758:
        r6 = "layout/deposit_constructor_view_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0766;
    L_0x0760:
        r6 = new com.iqoption.d.gd;
        r6.<init>(r4, r5);
        return r6;
    L_0x0766:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_constructor_view is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x077d:
        r6 = "layout/dialog_closed_deals_header_list_cfd_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x078b;
    L_0x0785:
        r6 = new com.iqoption.d.hw;
        r6.<init>(r4, r5);
        return r6;
    L_0x078b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_closed_deals_header_list_cfd is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x07a2:
        r6 = "layout/fragment_market_is_open_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x07b0;
    L_0x07aa:
        r6 = new com.iqoption.d.oo;
        r6.<init>(r4, r5);
        return r6;
    L_0x07b0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_market_is_open is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x07c7:
        r6 = "layout/layout_amount_selector_collapsed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x07d5;
    L_0x07cf:
        r6 = new com.iqoption.d.wu;
        r6.<init>(r4, r5);
        return r6;
    L_0x07d5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for layout_amount_selector_collapsed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x07ec:
        r6 = "layout/gif_whats_new_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x07fa;
    L_0x07f4:
        r6 = new com.iqoption.d.vk;
        r6.<init>(r4, r5);
        return r6;
    L_0x07fa:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for gif_whats_new_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0811:
        r6 = "layout/chat_suggestion_message_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x081f;
    L_0x0819:
        r6 = new com.iqoption.d.en;
        r6.<init>(r4, r5);
        return r6;
    L_0x081f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_suggestion_message_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0836:
        r6 = "layout/fragment_otn_leading_board_profile_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0844;
    L_0x083e:
        r6 = new com.iqoption.d.pm;
        r6.<init>(r4, r5);
        return r6;
    L_0x0844:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_otn_leading_board_profile is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x085b:
        r6 = "layout/dialog_margin_add_on_position_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0869;
    L_0x0863:
        r6 = new com.iqoption.d.is;
        r6.<init>(r4, r5);
        return r6;
    L_0x0869:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_margin_add_on_position is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0880:
        r6 = "layout/macro_article_feed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x088e;
    L_0x0888:
        r6 = new com.iqoption.d.yn;
        r6.<init>(r4, r5);
        return r6;
    L_0x088e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for macro_article_feed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x08a5:
        r6 = "layout/micro_portfolio_pending_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x08b3;
    L_0x08ad:
        r6 = new com.iqoption.d.aav;
        r6.<init>(r4, r5);
        return r6;
    L_0x08b3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_pending_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x08ca:
        r6 = "layout/fragment_quiz_promocode_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x08d8;
    L_0x08d2:
        r6 = new com.iqoption.d.rq;
        r6.<init>(r4, r5);
        return r6;
    L_0x08d8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_promocode_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x08ef:
        r6 = "layout/bottom_sheet_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x08fd;
    L_0x08f7:
        r6 = new com.iqoption.d.bh;
        r6.<init>(r4, r5);
        return r6;
    L_0x08fd:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for bottom_sheet_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0914:
        r6 = "layout/account_security_confirmed_email_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0922;
    L_0x091c:
        r6 = new com.iqoption.d.j;
        r6.<init>(r4, r5);
        return r6;
    L_0x0922:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for account_security_confirmed_email_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0939:
        r6 = "layout/micro_portfolio_exp_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0947;
    L_0x0941:
        r6 = new com.iqoption.d.zz;
        r6.<init>(r4, r5);
        return r6;
    L_0x0947:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_exp_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x095e:
        r6 = "layout/fragment_kyc_question_warning2_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x096c;
    L_0x0966:
        r6 = new com.iqoption.d.nq;
        r6.<init>(r4, r5);
        return r6;
    L_0x096c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_question_warning2 is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0983:
        r6 = "layout/fragment_welcome_registration_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0991;
    L_0x098b:
        r6 = new com.iqoption.d.uh;
        r6.<init>(r4, r5);
        return r6;
    L_0x0991:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_welcome_registration is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x09a8:
        r6 = "layout/micro_portfolio_mkt_on_open_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x09b6;
    L_0x09b0:
        r6 = new com.iqoption.d.aaf;
        r6.<init>(r4, r5);
        return r6;
    L_0x09b6:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_mkt_on_open_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x09cd:
        r6 = "layout/whats_new_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x09db;
    L_0x09d5:
        r6 = new com.iqoption.d.amb;
        r6.<init>(r4, r5);
        return r6;
    L_0x09db:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for whats_new_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x09f2:
        r6 = "layout/iqkeyboard_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0a00;
    L_0x09fa:
        r6 = new com.iqoption.d.vw;
        r6.<init>(r4, r5);
        return r6;
    L_0x0a00:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for iqkeyboard_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0a17:
        r6 = "layout/fragment_kyc_question_yes_no_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0a25;
    L_0x0a1f:
        r6 = new com.iqoption.d.nu;
        r6.<init>(r4, r5);
        return r6;
    L_0x0a25:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_question_yes_no is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0a3c:
        r6 = "layout/chat_file_message_body_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0a4a;
    L_0x0a44:
        r6 = new com.iqoption.d.cl;
        r6.<init>(r4, r5);
        return r6;
    L_0x0a4a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_file_message_body_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0a61:
        r6 = "layout/ichimoku_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0a6f;
    L_0x0a69:
        r6 = new com.iqoption.d.vo;
        r6.<init>(r4, r5);
        return r6;
    L_0x0a6f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for ichimoku_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0a86:
        r6 = "layout/left_menu_item_button_grayed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0a94;
    L_0x0a8e:
        r6 = new com.iqoption.d.xn;
        r6.<init>(r4, r5);
        return r6;
    L_0x0a94:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item_button_grayed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0aab:
        r6 = "layout/verify_side_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0ab9;
    L_0x0ab3:
        r6 = new com.iqoption.d.alf;
        r6.<init>(r4, r5);
        return r6;
    L_0x0ab9:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for verify_side_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0ad0:
        r6 = "layout/signal_title_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0ade;
    L_0x0ad8:
        r6 = new com.iqoption.d.ajl;
        r6.<init>(r4, r5);
        return r6;
    L_0x0ade:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for signal_title_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0af5:
        r6 = "layout/portfolio_cfd_single_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0b03;
    L_0x0afd:
        r6 = new com.iqoption.d.aef;
        r6.<init>(r4, r5);
        return r6;
    L_0x0b03:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_cfd_single_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0b1a:
        r6 = "layout/chat_user_file_message_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0b28;
    L_0x0b22:
        r6 = new com.iqoption.d.ez;
        r6.<init>(r4, r5);
        return r6;
    L_0x0b28:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_user_file_message_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0b3f:
        r6 = "layout/account_security_confirmed_phone_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0b4d;
    L_0x0b47:
        r6 = new com.iqoption.d.l;
        r6.<init>(r4, r5);
        return r6;
    L_0x0b4d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for account_security_confirmed_phone_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0b64:
        r6 = "layout/fragment_withdraw_history_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0b72;
    L_0x0b6c:
        r6 = new com.iqoption.d.up;
        r6.<init>(r4, r5);
        return r6;
    L_0x0b72:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_withdraw_history is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0b89:
        r6 = "layout/fragment_account_security_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0b97;
    L_0x0b91:
        r6 = new com.iqoption.d.la;
        r6.<init>(r4, r5);
        return r6;
    L_0x0b97:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_account_security is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0bae:
        r6 = "layout/fragment_withdraw_verify_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0bbc;
    L_0x0bb6:
        r6 = new com.iqoption.d.ut;
        r6.<init>(r4, r5);
        return r6;
    L_0x0bbc:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_withdraw_verify is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0bd3:
        r6 = "layout/fragment_kyc_block_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0be1;
    L_0x0bdb:
        r6 = new com.iqoption.d.mc;
        r6.<init>(r4, r5);
        return r6;
    L_0x0be1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_block is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0bf8:
        r6 = "layout/micro_portfolio_page_pending_positions_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0c06;
    L_0x0c00:
        r6 = new com.iqoption.d.aar;
        r6.<init>(r4, r5);
        return r6;
    L_0x0c06:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_page_pending_positions is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0c1d:
        r6 = "layout/dialpad_key_back_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0c2b;
    L_0x0c25:
        r6 = new com.iqoption.d.kg;
        r6.<init>(r4, r5);
        return r6;
    L_0x0c2b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialpad_key_back is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0c42:
        r6 = "layout/trailing_whats_new_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0c50;
    L_0x0c4a:
        r6 = new com.iqoption.d.akz;
        r6.<init>(r4, r5);
        return r6;
    L_0x0c50:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for trailing_whats_new_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0c67:
        r6 = "layout/fragment_push_settings_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0c75;
    L_0x0c6f:
        r6 = new com.iqoption.d.qm;
        r6.<init>(r4, r5);
        return r6;
    L_0x0c75:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_push_settings is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0c8c:
        r6 = "layout/otn_leader_board_first_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0c9a;
    L_0x0c94:
        r6 = new com.iqoption.d.acx;
        r6.<init>(r4, r5);
        return r6;
    L_0x0c9a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for otn_leader_board_first_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0cb1:
        r6 = "layout/portfolio_pending_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0cbf;
    L_0x0cb9:
        r6 = new com.iqoption.d.afy;
        r6.<init>(r4, r5);
        return r6;
    L_0x0cbf:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_pending_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0cd6:
        r6 = "layout/feed_bottom_panel_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0ce8;
    L_0x0cde:
        r6 = new com.iqoption.d.ks;
        r0 = new android.view.View[r2];
        r0[r1] = r5;
        r6.<init>(r4, r0);
        return r6;
    L_0x0ce8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for feed_bottom_panel is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0cff:
        r6 = "layout/dialpad_key_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0d0d;
    L_0x0d07:
        r6 = new com.iqoption.d.ki;
        r6.<init>(r4, r5);
        return r6;
    L_0x0d0d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialpad_key is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0d24:
        r6 = "layout/chat_rate_message_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0d32;
    L_0x0d2c:
        r6 = new com.iqoption.d.dz;
        r6.<init>(r4, r5);
        return r6;
    L_0x0d32:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_rate_message_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0d49:
        r6 = "layout/template_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0d57;
    L_0x0d51:
        r6 = new com.iqoption.d.akh;
        r6.<init>(r4, r5);
        return r6;
    L_0x0d57:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for template_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0d6e:
        r6 = "layout/otn_leader_board_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0d7c;
    L_0x0d76:
        r6 = new com.iqoption.d.acz;
        r6.<init>(r4, r5);
        return r6;
    L_0x0d7c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for otn_leader_board_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0d93:
        r6 = "layout/expiration_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0da1;
    L_0x0d9b:
        r6 = new com.iqoption.d.kq;
        r6.<init>(r4, r5);
        return r6;
    L_0x0da1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for expiration_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0db8:
        r6 = "layout/otn_history_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0dc6;
    L_0x0dc0:
        r6 = new com.iqoption.d.act;
        r6.<init>(r4, r5);
        return r6;
    L_0x0dc6:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for otn_history_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0ddd:
        r6 = "layout/overnight_fee_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0deb;
    L_0x0de5:
        r6 = new com.iqoption.d.add;
        r6.<init>(r4, r5);
        return r6;
    L_0x0deb:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for overnight_fee_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0e02:
        r6 = "layout/fragment_otn_leading_board_user_board_date_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0e10;
    L_0x0e0a:
        r6 = new com.iqoption.d.pq;
        r6.<init>(r4, r5);
        return r6;
    L_0x0e10:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_otn_leading_board_user_board_date is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0e27:
        r6 = "layout/fragment_quiz_leaderboard_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0e35;
    L_0x0e2f:
        r6 = new com.iqoption.d.ra;
        r6.<init>(r4, r5);
        return r6;
    L_0x0e35:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_leaderboard_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0e4c:
        r6 = "layout/chat_user_text_message_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0e5a;
    L_0x0e54:
        r6 = new com.iqoption.d.fd;
        r6.<init>(r4, r5);
        return r6;
    L_0x0e5a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_user_text_message_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0e71:
        r6 = "layout/portfolio_macro_filter_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0e7f;
    L_0x0e79:
        r6 = new com.iqoption.d.afc;
        r6.<init>(r4, r5);
        return r6;
    L_0x0e7f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_macro_filter_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0e96:
        r6 = "layout/left_menu_item_counter_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0ea4;
    L_0x0e9e:
        r6 = new com.iqoption.d.xr;
        r6.<init>(r4, r5);
        return r6;
    L_0x0ea4:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item_counter is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0ebb:
        r6 = "layout/fragment_kyc_country_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0ec9;
    L_0x0ec3:
        r6 = new com.iqoption.d.mg;
        r6.<init>(r4, r5);
        return r6;
    L_0x0ec9:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_country is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0ee0:
        r6 = "layout/deposit_page_content_no_bonus_old_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0eee;
    L_0x0ee8:
        r6 = new com.iqoption.d.gw;
        r6.<init>(r4, r5);
        return r6;
    L_0x0eee:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_page_content_no_bonus_old is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0f05:
        r6 = "layout/cfd_expiration_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0f13;
    L_0x0f0d:
        r6 = new com.iqoption.d.bx;
        r6.<init>(r4, r5);
        return r6;
    L_0x0f13:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for cfd_expiration_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0f2a:
        r6 = "layout/fragment_trading_history_set_date_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0f38;
    L_0x0f32:
        r6 = new com.iqoption.d.ta;
        r6.<init>(r4, r5);
        return r6;
    L_0x0f38:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_trading_history_set_date is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0f4f:
        r6 = "layout/chat_load_more_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0f5d;
    L_0x0f57:
        r6 = new com.iqoption.d.dt;
        r6.<init>(r4, r5);
        return r6;
    L_0x0f5d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_load_more_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0f74:
        r6 = "layout/base_menu_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0f82;
    L_0x0f7c:
        r6 = new com.iqoption.d.au;
        r6.<init>(r4, r5);
        return r6;
    L_0x0f82:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for base_menu_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0f99:
        r6 = "layout/macro_tweet_feed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0fa7;
    L_0x0fa1:
        r6 = new com.iqoption.d.yv;
        r6.<init>(r4, r5);
        return r6;
    L_0x0fa7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for macro_tweet_feed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0fbe:
        r6 = "layout/chat_fragment_image_preview_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0fcc;
    L_0x0fc6:
        r6 = new com.iqoption.d.db;
        r6.<init>(r4, r5);
        return r6;
    L_0x0fcc:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_fragment_image_preview is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0fe3:
        r6 = "layout/withdraw_method_card_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0ff1;
    L_0x0feb:
        r6 = new com.iqoption.d.amw;
        r6.<init>(r4, r5);
        return r6;
    L_0x0ff1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for withdraw_method_card_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1008:
        r6 = "layout/feed_web_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1016;
    L_0x1010:
        r6 = new com.iqoption.d.ky;
        r6.<init>(r4, r5);
        return r6;
    L_0x1016:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for feed_web is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x102d:
        r6 = "layout/portfolio_cfd_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x103b;
    L_0x1035:
        r6 = new com.iqoption.d.adz;
        r6.<init>(r4, r5);
        return r6;
    L_0x103b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_cfd_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1052:
        r6 = "layout/micro_portfolio_closed_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1060;
    L_0x105a:
        r6 = new com.iqoption.d.zt;
        r6.<init>(r4, r5);
        return r6;
    L_0x1060:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_closed_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1077:
        r6 = "layout/bottom_sheet_overnight_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1085;
    L_0x107f:
        r6 = new com.iqoption.d.bn;
        r6.<init>(r4, r5);
        return r6;
    L_0x1085:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for bottom_sheet_overnight is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x109c:
        r6 = "layout/crypto_confirm_dialog_view_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x10ae;
    L_0x10a4:
        r6 = new com.iqoption.d.ft;
        r0 = new android.view.View[r2];
        r0[r1] = r5;
        r6.<init>(r4, r0);
        return r6;
    L_0x10ae:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for crypto_confirm_dialog_view is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x10c5:
        r6 = "layout/fragment_technical_log_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x10d3;
    L_0x10cd:
        r6 = new com.iqoption.d.si;
        r6.<init>(r4, r5);
        return r6;
    L_0x10d3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_technical_log is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x10ea:
        r6 = "layout/operation_history_multi_selection_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x10f8;
    L_0x10f2:
        r6 = new com.iqoption.d.acn;
        r6.<init>(r4, r5);
        return r6;
    L_0x10f8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for operation_history_multi_selection is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x110f:
        r6 = "layout/top_panel_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x111d;
    L_0x1117:
        r6 = new com.iqoption.d.akx;
        r6.<init>(r4, r5);
        return r6;
    L_0x111d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for top_panel is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1134:
        r6 = "layout/indicator_title_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1142;
    L_0x113c:
        r6 = new com.iqoption.d.vs;
        r6.<init>(r4, r5);
        return r6;
    L_0x1142:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for indicator_title_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1159:
        r6 = "layout/micro_portfolio_pending_empty_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1167;
    L_0x1161:
        r6 = new com.iqoption.d.aat;
        r6.<init>(r4, r5);
        return r6;
    L_0x1167:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_pending_empty_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x117e:
        r6 = "layout/dialog_trailing_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x118c;
    L_0x1186:
        r6 = new com.iqoption.d.jw;
        r6.<init>(r4, r5);
        return r6;
    L_0x118c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_trailing_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x11a3:
        r6 = "layout/legal_update_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x11b1;
    L_0x11ab:
        r6 = new com.iqoption.d.yj;
        r6.<init>(r4, r5);
        return r6;
    L_0x11b1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for legal_update is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x11c8:
        r6 = "layout/micro_portfolio_closed_empty_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x11d6;
    L_0x11d0:
        r6 = new com.iqoption.d.zr;
        r6.<init>(r4, r5);
        return r6;
    L_0x11d6:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_closed_empty_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x11ed:
        r6 = "layout/fragment_vip_about_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x11fb;
    L_0x11f5:
        r6 = new com.iqoption.d.tu;
        r6.<init>(r4, r5);
        return r6;
    L_0x11fb:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_vip_about is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1212:
        r6 = "layout/deposit_old_3ds_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1220;
    L_0x121a:
        r6 = new com.iqoption.d.gj;
        r6.<init>(r4, r5);
        return r6;
    L_0x1220:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_old_3ds is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1237:
        r6 = "layout/dialog_tpsl_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1245;
    L_0x123f:
        r6 = new com.iqoption.d.js;
        r6.<init>(r4, r5);
        return r6;
    L_0x1245:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_tpsl is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x125c:
        r6 = "layout/chat_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x126a;
    L_0x1264:
        r6 = new com.iqoption.d.dp;
        r6.<init>(r4, r5);
        return r6;
    L_0x126a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1281:
        r6 = "layout/popup_window_otn_leader_board_select_country_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x128f;
    L_0x1289:
        r6 = new com.iqoption.d.adn;
        r6.<init>(r4, r5);
        return r6;
    L_0x128f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for popup_window_otn_leader_board_select_country is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x12a6:
        r6 = "layout/nps_feedback_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x12b4;
    L_0x12ae:
        r6 = new com.iqoption.d.abr;
        r6.<init>(r4, r5);
        return r6;
    L_0x12b4:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for nps_feedback_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x12cb:
        r6 = "layout/perform_verify_footer_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x12d9;
    L_0x12d3:
        r6 = new com.iqoption.d.adf;
        r6.<init>(r4, r5);
        return r6;
    L_0x12d9:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for perform_verify_footer is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x12f0:
        r6 = "layout/session_main_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x12fe;
    L_0x12f8:
        r6 = new com.iqoption.d.aiz;
        r6.<init>(r4, r5);
        return r6;
    L_0x12fe:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for session_main_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1315:
        r6 = "layout/multi_asset_view_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1323;
    L_0x131d:
        r6 = new com.iqoption.d.abl;
        r6.<init>(r4, r5);
        return r6;
    L_0x1323:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for multi_asset_view is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x133a:
        r6 = "layout/fragment_quiz_error_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1348;
    L_0x1342:
        r6 = new com.iqoption.d.qq;
        r6.<init>(r4, r5);
        return r6;
    L_0x1348:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_error_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x135f:
        r6 = "layout/portfolio_delegate_micro_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x136d;
    L_0x1367:
        r6 = new com.iqoption.d.aem;
        r6.<init>(r4, r5);
        return r6;
    L_0x136d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_delegate_micro is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1384:
        r6 = "layout-land/fragment_operation_search_result_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1392;
    L_0x138c:
        r6 = new com.iqoption.d.pi;
        r6.<init>(r4, r5);
        return r6;
    L_0x1392:
        r6 = "layout/fragment_operation_search_result_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x13a0;
    L_0x139a:
        r6 = new com.iqoption.d.ph;
        r6.<init>(r4, r5);
        return r6;
    L_0x13a0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_operation_search_result is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x13b7:
        r6 = "layout/fx_strike_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x13c5;
    L_0x13bf:
        r6 = new com.iqoption.d.vg;
        r6.<init>(r4, r5);
        return r6;
    L_0x13c5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fx_strike_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x13dc:
        r6 = "layout/deposit_page_crypto_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x13ea;
    L_0x13e4:
        r6 = new com.iqoption.d.gy;
        r6.<init>(r4, r5);
        return r6;
    L_0x13ea:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_page_crypto is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1401:
        r6 = "layout/macro_smart_feed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x140f;
    L_0x1409:
        r6 = new com.iqoption.d.yt;
        r6.<init>(r4, r5);
        return r6;
    L_0x140f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for macro_smart_feed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1426:
        r6 = "layout/micro_portfolio_cfd_single_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1434;
    L_0x142e:
        r6 = new com.iqoption.d.zp;
        r6.<init>(r4, r5);
        return r6;
    L_0x1434:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_cfd_single_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x144b:
        r6 = "layout/price_movements_filter_menu_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1459;
    L_0x1453:
        r6 = new com.iqoption.d.agn;
        r6.<init>(r4, r5);
        return r6;
    L_0x1459:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for price_movements_filter_menu_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1470:
        r6 = "layout/portfolio_mkt_on_open_single_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x147e;
    L_0x1478:
        r6 = new com.iqoption.d.afi;
        r6.<init>(r4, r5);
        return r6;
    L_0x147e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_mkt_on_open_single_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1495:
        r6 = "layout/micro_portfolio_cfd_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x14a3;
    L_0x149d:
        r6 = new com.iqoption.d.zl;
        r6.<init>(r4, r5);
        return r6;
    L_0x14a3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_cfd_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x14ba:
        r6 = "layout/fragment_kyc_check_box_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x14c8;
    L_0x14c2:
        r6 = new com.iqoption.d.me;
        r6.<init>(r4, r5);
        return r6;
    L_0x14c8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_check_box is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x14df:
        r6 = "layout/feed_title_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x14f1;
    L_0x14e7:
        r6 = new com.iqoption.d.kw;
        r0 = new android.view.View[r2];
        r0[r1] = r5;
        r6.<init>(r4, r0);
        return r6;
    L_0x14f1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for feed_title is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1508:
        r6 = "layout/deposit_page_content_no_bonus_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1516;
    L_0x1510:
        r6 = new com.iqoption.d.gu;
        r6.<init>(r4, r5);
        return r6;
    L_0x1516:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_page_content_no_bonus is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x152d:
        r6 = "layout/portfolio_cfd_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x153b;
    L_0x1535:
        r6 = new com.iqoption.d.aed;
        r6.<init>(r4, r5);
        return r6;
    L_0x153b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_cfd_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1552:
        r6 = "layout/fragment_forgot_password_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1560;
    L_0x155a:
        r6 = new com.iqoption.d.lt;
        r6.<init>(r4, r5);
        return r6;
    L_0x1560:
        r6 = "layout-land/fragment_forgot_password_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x156e;
    L_0x1568:
        r6 = new com.iqoption.d.lu;
        r6.<init>(r4, r5);
        return r6;
    L_0x156e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_forgot_password is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1585:
        r6 = "layout/menu_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1593;
    L_0x158d:
        r6 = new com.iqoption.d.yz;
        r6.<init>(r4, r5);
        return r6;
    L_0x1593:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for menu_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x15aa:
        r6 = "layout/price_movements_progress_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x15b8;
    L_0x15b2:
        r6 = new com.iqoption.d.agz;
        r6.<init>(r4, r5);
        return r6;
    L_0x15b8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for price_movements_progress is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x15cf:
        r6 = "layout/close_positions_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x15dd;
    L_0x15d7:
        r6 = new com.iqoption.d.fl;
        r6.<init>(r4, r5);
        return r6;
    L_0x15dd:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for close_positions_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x15f4:
        r6 = "layout/fragment_quiz_off_air_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1602;
    L_0x15fc:
        r6 = new com.iqoption.d.rk;
        r6.<init>(r4, r5);
        return r6;
    L_0x1602:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_off_air_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1619:
        r6 = "layout/price_movements_tittle_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1627;
    L_0x1621:
        r6 = new com.iqoption.d.ahb;
        r6.<init>(r4, r5);
        return r6;
    L_0x1627:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for price_movements_tittle_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x163e:
        r6 = "layout/item_currency_selection_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x164c;
    L_0x1646:
        r6 = new com.iqoption.d.wc;
        r6.<init>(r4, r5);
        return r6;
    L_0x164c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for item_currency_selection is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1663:
        r6 = "layout/deposit_terms_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1671;
    L_0x166b:
        r6 = new com.iqoption.d.hm;
        r6.<init>(r4, r5);
        return r6;
    L_0x1671:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_terms_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1688:
        r6 = "layout/fragment_kyc_phone_confirm_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1696;
    L_0x1690:
        r6 = new com.iqoption.d.ni;
        r6.<init>(r4, r5);
        return r6;
    L_0x1696:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_phone_confirm is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x16ad:
        r6 = "layout/right_panel_delegate_crypto_confirmation_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x16bb;
    L_0x16b5:
        r6 = new com.iqoption.d.ahz;
        r6.<init>(r4, r5);
        return r6;
    L_0x16bb:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_crypto_confirmation is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x16d2:
        r6 = "layout/fragment_room_list_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x16e0;
    L_0x16da:
        r6 = new com.iqoption.d.sc;
        r6.<init>(r4, r5);
        return r6;
    L_0x16e0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_room_list is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x16f7:
        r6 = "layout/close_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1705;
    L_0x16ff:
        r6 = new com.iqoption.d.fh;
        r6.<init>(r4, r5);
        return r6;
    L_0x1705:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for close_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x171c:
        r6 = "layout/account_security_email_confirm_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x172a;
    L_0x1724:
        r6 = new com.iqoption.d.n;
        r6.<init>(r4, r5);
        return r6;
    L_0x172a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for account_security_email_confirm_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1741:
        r6 = "layout/fragment_withdraw_complete_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x174f;
    L_0x1749:
        r6 = new com.iqoption.d.ul;
        r6.<init>(r4, r5);
        return r6;
    L_0x174f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_withdraw_complete is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1766:
        r6 = "layout/selling_price_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1774;
    L_0x176e:
        r6 = new com.iqoption.d.aix;
        r6.<init>(r4, r5);
        return r6;
    L_0x1774:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for selling_price_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x178b:
        r6 = "layout/chat_dialog_feedback_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1799;
    L_0x1793:
        r6 = new com.iqoption.d.cd;
        r6.<init>(r4, r5);
        return r6;
    L_0x1799:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_dialog_feedback is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x17b0:
        r6 = "layout/small_numpad_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x17be;
    L_0x17b8:
        r6 = new com.iqoption.d.ajn;
        r6.<init>(r4, r5);
        return r6;
    L_0x17be:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for small_numpad is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x17d5:
        r6 = "layout/dialog_margin_add_on_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x17e3;
    L_0x17dd:
        r6 = new com.iqoption.d.iq;
        r6.<init>(r4, r5);
        return r6;
    L_0x17e3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_margin_add_on_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x17fa:
        r6 = "layout/chat_dialog_cant_send_reason_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1808;
    L_0x1802:
        r6 = new com.iqoption.d.cb;
        r6.<init>(r4, r5);
        return r6;
    L_0x1808:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_dialog_cant_send_reason is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x181f:
        r6 = "layout/micro_portfolio_exp_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x182d;
    L_0x1827:
        r6 = new com.iqoption.d.aab;
        r6.<init>(r4, r5);
        return r6;
    L_0x182d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_exp_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1844:
        r6 = "layout/portfolio_pending_header_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1852;
    L_0x184c:
        r6 = new com.iqoption.d.afw;
        r6.<init>(r4, r5);
        return r6;
    L_0x1852:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_pending_header_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1869:
        r6 = "layout/chat_loading_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1877;
    L_0x1871:
        r6 = new com.iqoption.d.dv;
        r6.<init>(r4, r5);
        return r6;
    L_0x1877:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_loading_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x188e:
        r6 = "layout/kyc_continue_button_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x189c;
    L_0x1896:
        r6 = new com.iqoption.d.wq;
        r6.<init>(r4, r5);
        return r6;
    L_0x189c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for kyc_continue_button is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x18b3:
        r6 = "layout/popup_window_otn_leader_board_user_details_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x18c1;
    L_0x18bb:
        r6 = new com.iqoption.d.adp;
        r6.<init>(r4, r5);
        return r6;
    L_0x18c1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for popup_window_otn_leader_board_user_details is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x18d8:
        r6 = "layout/account_security_turn_on_2step_auth_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x18e6;
    L_0x18e0:
        r6 = new com.iqoption.d.t;
        r6.<init>(r4, r5);
        return r6;
    L_0x18e6:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for account_security_turn_on_2step_auth_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x18fd:
        r6 = "layout/dialog_otn_reward_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x190b;
    L_0x1905:
        r6 = new com.iqoption.d.ja;
        r6.<init>(r4, r5);
        return r6;
    L_0x190b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_otn_reward_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1922:
        r6 = "layout/dialog_gdpr_warning_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1930;
    L_0x192a:
        r6 = new com.iqoption.d.io;
        r6.<init>(r4, r5);
        return r6;
    L_0x1930:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_gdpr_warning is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1947:
        r6 = "layout/verify_side_hint_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1955;
    L_0x194f:
        r6 = new com.iqoption.d.ald;
        r6.<init>(r4, r5);
        return r6;
    L_0x1955:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for verify_side_hint is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x196c:
        r6 = "layout/fragment_trading_history_search_result_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x197a;
    L_0x1974:
        r6 = new com.iqoption.d.su;
        r6.<init>(r4, r5);
        return r6;
    L_0x197a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_trading_history_search_result is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1991:
        r6 = "layout/chat_text_message_head_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x199f;
    L_0x1999:
        r6 = new com.iqoption.d.et;
        r6.<init>(r4, r5);
        return r6;
    L_0x199f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_text_message_head_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x19b6:
        r6 = "layout/deposit_page_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x19c4;
    L_0x19be:
        r6 = new com.iqoption.d.gp;
        r6.<init>(r4, r5);
        return r6;
    L_0x19c4:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_page is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x19db:
        r6 = "layout/chat_file_message_full_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x19e9;
    L_0x19e3:
        r6 = new com.iqoption.d.cn;
        r6.<init>(r4, r5);
        return r6;
    L_0x19e9:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_file_message_full_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1a00:
        r6 = "layout/signal_loading_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1a0e;
    L_0x1a08:
        r6 = new com.iqoption.d.ajj;
        r6.<init>(r4, r5);
        return r6;
    L_0x1a0e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for signal_loading_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1a25:
        r6 = "layout/dialpad_key_zero_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1a33;
    L_0x1a2d:
        r6 = new com.iqoption.d.km;
        r6.<init>(r4, r5);
        return r6;
    L_0x1a33:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialpad_key_zero is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1a4a:
        r6 = "layout/chat_image_message_head_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1a58;
    L_0x1a52:
        r6 = new com.iqoption.d.dl;
        r6.<init>(r4, r5);
        return r6;
    L_0x1a58:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_image_message_head_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1a6f:
        r6 = "layout/string_basket_empty_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1a7d;
    L_0x1a77:
        r6 = new com.iqoption.d.ajv;
        r6.<init>(r4, r5);
        return r6;
    L_0x1a7d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for string_basket_empty_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1a94:
        r6 = "layout/price_movements_high_frequecy_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1aa2;
    L_0x1a9c:
        r6 = new com.iqoption.d.agt;
        r6.<init>(r4, r5);
        return r6;
    L_0x1aa2:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for price_movements_high_frequecy_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1ab9:
        r6 = "layout/portfolio_exp_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1ac7;
    L_0x1ac1:
        r6 = new com.iqoption.d.aeo;
        r6.<init>(r4, r5);
        return r6;
    L_0x1ac7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_exp_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1ade:
        r6 = "layout/left_menu_item_pro_trader_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1aec;
    L_0x1ae6:
        r6 = new com.iqoption.d.xz;
        r6.<init>(r4, r5);
        return r6;
    L_0x1aec:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item_pro_trader is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1b03:
        r6 = "layout/fragment_quiz_loading_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1b11;
    L_0x1b0b:
        r6 = new com.iqoption.d.ri;
        r6.<init>(r4, r5);
        return r6;
    L_0x1b11:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_loading_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1b28:
        r6 = "layout/chat_fragment_image_preview_slider_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1b36;
    L_0x1b30:
        r6 = new com.iqoption.d.dd;
        r6.<init>(r4, r5);
        return r6;
    L_0x1b36:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_fragment_image_preview_slider is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1b4d:
        r6 = "layout/right_panel_delegate_crypto_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1b5b;
    L_0x1b55:
        r6 = new com.iqoption.d.ahv;
        r6.<init>(r4, r5);
        return r6;
    L_0x1b5b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_crypto is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1b72:
        r6 = "layout/chat_empty_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1b80;
    L_0x1b7a:
        r6 = new com.iqoption.d.cj;
        r6.<init>(r4, r5);
        return r6;
    L_0x1b80:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_empty_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1b97:
        r6 = "layout/push_settings_category_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1ba5;
    L_0x1b9f:
        r6 = new com.iqoption.d.ahd;
        r6.<init>(r4, r5);
        return r6;
    L_0x1ba5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for push_settings_category_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1bbc:
        r6 = "layout/layout_pro_trader_benefits_bottom_row_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1bca;
    L_0x1bc4:
        r6 = new com.iqoption.d.wy;
        r6.<init>(r4, r5);
        return r6;
    L_0x1bca:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for layout_pro_trader_benefits_bottom_row is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1be1:
        r6 = "layout/fragment_quiz_error_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1bef;
    L_0x1be9:
        r6 = new com.iqoption.d.qs;
        r6.<init>(r4, r5);
        return r6;
    L_0x1bef:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_error_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1c06:
        r6 = "layout/right_panel_delegate_on_open_cfd_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1c14;
    L_0x1c0e:
        r6 = new com.iqoption.d.ail;
        r6.<init>(r4, r5);
        return r6;
    L_0x1c14:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_on_open_cfd is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1c2b:
        r6 = "layout/personal_info_page_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1c39;
    L_0x1c33:
        r6 = new com.iqoption.d.adj;
        r6.<init>(r4, r5);
        return r6;
    L_0x1c39:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for personal_info_page is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1c50:
        r6 = "layout/deposit_page_amount_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1c5e;
    L_0x1c58:
        r6 = new com.iqoption.d.gn;
        r6.<init>(r4, r5);
        return r6;
    L_0x1c5e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_page_amount_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1c75:
        r6 = "layout/tools_content_indicators_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1c83;
    L_0x1c7d:
        r6 = new com.iqoption.d.akp;
        r6.<init>(r4, r5);
        return r6;
    L_0x1c83:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for tools_content_indicators is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1c9a:
        r6 = "layout/left_menu_item_button_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1ca8;
    L_0x1ca2:
        r6 = new com.iqoption.d.xl;
        r6.<init>(r4, r5);
        return r6;
    L_0x1ca8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item_button is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1cbf:
        r6 = "layout/bottom_sheet_message_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1ccd;
    L_0x1cc7:
        r6 = new com.iqoption.d.bj;
        r6.<init>(r4, r5);
        return r6;
    L_0x1ccd:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for bottom_sheet_message is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1ce4:
        r6 = "layout/fragment_kyc_document_address_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1cf2;
    L_0x1cec:
        r6 = new com.iqoption.d.mm;
        r6.<init>(r4, r5);
        return r6;
    L_0x1cf2:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_document_address is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1d09:
        r6 = "layout/deposit_page_old_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1d17;
    L_0x1d11:
        r6 = new com.iqoption.d.ha;
        r6.<init>(r4, r5);
        return r6;
    L_0x1d17:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_page_old is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1d2e:
        r6 = "layout/account_security_turn_on_touch_id_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1d3c;
    L_0x1d36:
        r6 = new com.iqoption.d.v;
        r6.<init>(r4, r5);
        return r6;
    L_0x1d3c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for account_security_turn_on_touch_id_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1d53:
        r6 = "layout/portfolio_balances_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1d61;
    L_0x1d5b:
        r6 = new com.iqoption.d.adx;
        r6.<init>(r4, r5);
        return r6;
    L_0x1d61:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_balances is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1d78:
        r6 = "layout/fragment_kyc_address_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1d86;
    L_0x1d80:
        r6 = new com.iqoption.d.ly;
        r6.<init>(r4, r5);
        return r6;
    L_0x1d86:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_address is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1d9d:
        r6 = "layout/right_panel_fx_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1dab;
    L_0x1da5:
        r6 = new com.iqoption.d.ait;
        r6.<init>(r4, r5);
        return r6;
    L_0x1dab:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_fx_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1dc2:
        r6 = "layout/account_security_phone_number_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1dd0;
    L_0x1dca:
        r6 = new com.iqoption.d.p;
        r6.<init>(r4, r5);
        return r6;
    L_0x1dd0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for account_security_phone_number_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1de7:
        r6 = "layout/fragment_deposit_methods_old_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1df5;
    L_0x1def:
        r6 = new com.iqoption.d.lr;
        r6.<init>(r4, r5);
        return r6;
    L_0x1df5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_deposit_methods_old is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1e0c:
        r6 = "layout/fragment_kyc_reportable_error_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1e1a;
    L_0x1e14:
        r6 = new com.iqoption.d.oa;
        r6.<init>(r4, r5);
        return r6;
    L_0x1e1a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_reportable_error is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1e31:
        r6 = "layout/toolbar_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1e3f;
    L_0x1e39:
        r6 = new com.iqoption.d.akl;
        r6.<init>(r4, r5);
        return r6;
    L_0x1e3f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for toolbar_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1e56:
        r6 = "layout/fragment_dark_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1e64;
    L_0x1e5e:
        r6 = new com.iqoption.d.lp;
        r6.<init>(r4, r5);
        return r6;
    L_0x1e64:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_dark_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1e7b:
        r6 = "layout/left_menu_item_drop_down_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1e89;
    L_0x1e83:
        r6 = new com.iqoption.d.xt;
        r6.<init>(r4, r5);
        return r6;
    L_0x1e89:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item_drop_down is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1ea0:
        r6 = "layout/dialog_warning_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1eae;
    L_0x1ea8:
        r6 = new com.iqoption.d.jy;
        r6.<init>(r4, r5);
        return r6;
    L_0x1eae:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_warning is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1ec5:
        r6 = "layout/activity_welcome_onboarding_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1ed3;
    L_0x1ecd:
        r6 = new com.iqoption.d.am;
        r6.<init>(r4, r5);
        return r6;
    L_0x1ed3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for activity_welcome_onboarding is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1eea:
        r6 = "layout/portfolio_delegate_macro_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1ef8;
    L_0x1ef2:
        r6 = new com.iqoption.d.aek;
        r6.<init>(r4, r5);
        return r6;
    L_0x1ef8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_delegate_macro is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1f0f:
        r6 = "layout/dialog_reload_practice_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1f1d;
    L_0x1f17:
        r6 = new com.iqoption.d.jq;
        r6.<init>(r4, r5);
        return r6;
    L_0x1f1d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_reload_practice is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1f34:
        r6 = "layout/chat_room_send_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1f42;
    L_0x1f3c:
        r6 = new com.iqoption.d.ei;
        r6.<init>(r4, r5);
        return r6;
    L_0x1f42:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_room_send_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1f59:
        r6 = "layout/chat_file_picker_empty_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1f67;
    L_0x1f61:
        r6 = new com.iqoption.d.ct;
        r6.<init>(r4, r5);
        return r6;
    L_0x1f67:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_file_picker_empty_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1f7e:
        r6 = "layout/fragment_kyc_gdpr_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1f8c;
    L_0x1f86:
        r6 = new com.iqoption.d.na;
        r6.<init>(r4, r5);
        return r6;
    L_0x1f8c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_gdpr is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1fa3:
        r6 = "layout/item_crypto_asset_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1fb1;
    L_0x1fab:
        r6 = new com.iqoption.d.wa;
        r6.<init>(r4, r5);
        return r6;
    L_0x1fb1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for item_crypto_asset is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1fc8:
        r6 = "layout/right_panel_closed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1fd6;
    L_0x1fd0:
        r6 = new com.iqoption.d.ahj;
        r6.<init>(r4, r5);
        return r6;
    L_0x1fd6:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_closed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x1fed:
        r6 = "layout/fragment_quiz_insights_title_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x1ffb;
    L_0x1ff5:
        r6 = new com.iqoption.d.qy;
        r6.<init>(r4, r5);
        return r6;
    L_0x1ffb:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_insights_title_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2012:
        r6 = "layout/whats_new_video_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2020;
    L_0x201a:
        r6 = new com.iqoption.d.amj;
        r6.<init>(r4, r5);
        return r6;
    L_0x2020:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for whats_new_video_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2037:
        r6 = "layout/portfolio_pending_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2045;
    L_0x203f:
        r6 = new com.iqoption.d.afu;
        r6.<init>(r4, r5);
        return r6;
    L_0x2045:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_pending_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x205c:
        r6 = "layout/fragment_quiz_insights_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x206a;
    L_0x2064:
        r6 = new com.iqoption.d.qw;
        r6.<init>(r4, r5);
        return r6;
    L_0x206a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_insights_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2081:
        r6 = "layout/micro_portfolio_pending_single_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x208f;
    L_0x2089:
        r6 = new com.iqoption.d.abb;
        r6.<init>(r4, r5);
        return r6;
    L_0x208f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_pending_single_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x20a6:
        r6 = "layout/fragment_tools_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x20b4;
    L_0x20ae:
        r6 = new com.iqoption.d.sm;
        r6.<init>(r4, r5);
        return r6;
    L_0x20b4:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_tools is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x20cb:
        r6 = "layout/fragment_onboardin_welcom_slide_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x20d9;
    L_0x20d3:
        r6 = new com.iqoption.d.oy;
        r6.<init>(r4, r5);
        return r6;
    L_0x20d9:
        r6 = "layout-land/fragment_onboardin_welcom_slide_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x20e7;
    L_0x20e1:
        r6 = new com.iqoption.d.oz;
        r6.<init>(r4, r5);
        return r6;
    L_0x20e7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_onboardin_welcom_slide is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x20fe:
        r6 = "layout/withdraw_history_title_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x210c;
    L_0x2106:
        r6 = new com.iqoption.d.amq;
        r6.<init>(r4, r5);
        return r6;
    L_0x210c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for withdraw_history_title_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2123:
        r6 = "layout/push_settings_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2131;
    L_0x212b:
        r6 = new com.iqoption.d.ahf;
        r6.<init>(r4, r5);
        return r6;
    L_0x2131:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for push_settings_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2148:
        r6 = "layout/fragment_trial_registration_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2156;
    L_0x2150:
        r6 = new com.iqoption.d.tc;
        r6.<init>(r4, r5);
        return r6;
    L_0x2156:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_trial_registration is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x216d:
        r6 = "layout/bitcoin_whats_new_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x217b;
    L_0x2175:
        r6 = new com.iqoption.d.bd;
        r6.<init>(r4, r5);
        return r6;
    L_0x217b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for bitcoin_whats_new_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2192:
        r6 = "layout/fragment_room_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x21a0;
    L_0x219a:
        r6 = new com.iqoption.d.sa;
        r6.<init>(r4, r5);
        return r6;
    L_0x21a0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_room is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x21b7:
        r6 = "layout/fragment_quiz_splash_pager_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x21c5;
    L_0x21bf:
        r6 = new com.iqoption.d.ru;
        r6.<init>(r4, r5);
        return r6;
    L_0x21c5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_splash_pager_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x21dc:
        r6 = "layout/layout_welcome_social_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x21ea;
    L_0x21e4:
        r6 = new com.iqoption.d.xg;
        r6.<init>(r4, r5);
        return r6;
    L_0x21ea:
        r6 = "layout-land/layout_welcome_social_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x21f8;
    L_0x21f2:
        r6 = new com.iqoption.d.xh;
        r6.<init>(r4, r5);
        return r6;
    L_0x21f8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for layout_welcome_social is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x220f:
        r6 = "layout/chat_fragment_file_picker_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x221d;
    L_0x2217:
        r6 = new com.iqoption.d.cz;
        r6.<init>(r4, r5);
        return r6;
    L_0x221d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_fragment_file_picker is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2234:
        r6 = "layout/chat_image_message_full_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2242;
    L_0x223c:
        r6 = new com.iqoption.d.dj;
        r6.<init>(r4, r5);
        return r6;
    L_0x2242:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_image_message_full_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2259:
        r6 = "layout/portfolio_balance_cash_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2267;
    L_0x2261:
        r6 = new com.iqoption.d.adt;
        r6.<init>(r4, r5);
        return r6;
    L_0x2267:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_balance_cash is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x227e:
        r6 = "layout/toolbar_black_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x228c;
    L_0x2286:
        r6 = new com.iqoption.d.akj;
        r6.<init>(r4, r5);
        return r6;
    L_0x228c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for toolbar_black_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x22a3:
        r6 = "layout/fragment_withdraw_methods_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x22b1;
    L_0x22ab:
        r6 = new com.iqoption.d.ur;
        r6.<init>(r4, r5);
        return r6;
    L_0x22b1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_withdraw_methods is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x22c8:
        r6 = "layout/fx_whats_new_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x22d6;
    L_0x22d0:
        r6 = new com.iqoption.d.vi;
        r6.<init>(r4, r5);
        return r6;
    L_0x22d6:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fx_whats_new_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x22ed:
        r6 = "layout/chat_room_support_toolbar_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x22fb;
    L_0x22f5:
        r6 = new com.iqoption.d.ek;
        r6.<init>(r4, r5);
        return r6;
    L_0x22fb:
        r6 = "layout-land/chat_room_support_toolbar_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2309;
    L_0x2303:
        r6 = new com.iqoption.d.el;
        r6.<init>(r4, r5);
        return r6;
    L_0x2309:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_room_support_toolbar is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2320:
        r6 = "layout/whats_new_dialog_spot_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x232e;
    L_0x2328:
        r6 = new com.iqoption.d.amf;
        r6.<init>(r4, r5);
        return r6;
    L_0x232e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for whats_new_dialog_spot is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2345:
        r6 = "layout/dialog_trade_on_practice_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2353;
    L_0x234d:
        r6 = new com.iqoption.d.ju;
        r6.<init>(r4, r5);
        return r6;
    L_0x2353:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_trade_on_practice is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x236a:
        r6 = "layout/fragment_otn_leading_board_user_board_user_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2378;
    L_0x2372:
        r6 = new com.iqoption.d.py;
        r6.<init>(r4, r5);
        return r6;
    L_0x2378:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_otn_leading_board_user_board_user is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x238f:
        r6 = "layout/fragment_tutorial_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x239d;
    L_0x2397:
        r6 = new com.iqoption.d.te;
        r6.<init>(r4, r5);
        return r6;
    L_0x239d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_tutorial is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x23b4:
        r6 = "layout/deposit_payment_unsuccessful_completed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x23c2;
    L_0x23bc:
        r6 = new com.iqoption.d.hk;
        r6.<init>(r4, r5);
        return r6;
    L_0x23c2:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_payment_unsuccessful_completed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x23d9:
        r6 = "layout/personal_info_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x23e7;
    L_0x23e1:
        r6 = new com.iqoption.d.adh;
        r6.<init>(r4, r5);
        return r6;
    L_0x23e7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for personal_info_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x23fe:
        r6 = "layout/portfolio_page_pending_positions_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x240c;
    L_0x2406:
        r6 = new com.iqoption.d.afq;
        r6.<init>(r4, r5);
        return r6;
    L_0x240c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_page_pending_positions is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2423:
        r6 = "layout/portfolio_open_header_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2431;
    L_0x242b:
        r6 = new com.iqoption.d.afm;
        r6.<init>(r4, r5);
        return r6;
    L_0x2431:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_open_header_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2448:
        r6 = "layout/portfolio_filter_options_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2456;
    L_0x2450:
        r6 = new com.iqoption.d.afa;
        r6.<init>(r4, r5);
        return r6;
    L_0x2456:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_filter_options is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x246d:
        r6 = "layout/fragment_verify_cards_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x247b;
    L_0x2475:
        r6 = new com.iqoption.d.ti;
        r6.<init>(r4, r5);
        return r6;
    L_0x247b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_verify_cards is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2492:
        r6 = "layout/left_menu_item_profile_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x24a0;
    L_0x249a:
        r6 = new com.iqoption.d.yb;
        r6.<init>(r4, r5);
        return r6;
    L_0x24a0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item_profile is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x24b7:
        r6 = "layout/portfolio_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x24c5;
    L_0x24bf:
        r6 = new com.iqoption.d.aeh;
        r6.<init>(r4, r5);
        return r6;
    L_0x24c5:
        r6 = "layout-land/portfolio_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x24d3;
    L_0x24cd:
        r6 = new com.iqoption.d.aei;
        r6.<init>(r4, r5);
        return r6;
    L_0x24d3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x24ea:
        r6 = "layout/fragment_traderoom_settings_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x24f8;
    L_0x24f2:
        r6 = new com.iqoption.d.sq;
        r6.<init>(r4, r5);
        return r6;
    L_0x24f8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_traderoom_settings is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x250f:
        r6 = "layout/activity_verify_cards_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x251d;
    L_0x2517:
        r6 = new com.iqoption.d.ak;
        r6.<init>(r4, r5);
        return r6;
    L_0x251d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for activity_verify_cards is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2534:
        r6 = "layout/layout_dialog_toolbar_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2542;
    L_0x253c:
        r6 = new com.iqoption.d.ww;
        r6.<init>(r4, r5);
        return r6;
    L_0x2542:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for layout_dialog_toolbar is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2559:
        r6 = "layout/asset_spinner_handle_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2567;
    L_0x2561:
        r6 = new com.iqoption.d.as;
        r6.<init>(r4, r5);
        return r6;
    L_0x2567:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for asset_spinner_handle is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x257e:
        r6 = "layout/activity_chat_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x258c;
    L_0x2586:
        r6 = new com.iqoption.d.ac;
        r6.<init>(r4, r5);
        return r6;
    L_0x258c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for activity_chat is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x25a3:
        r6 = "layout/fragment_kyc_phone_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x25b1;
    L_0x25ab:
        r6 = new com.iqoption.d.ng;
        r6.<init>(r4, r5);
        return r6;
    L_0x25b1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_phone is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x25c8:
        r6 = "layout/deposit_card_processing_page_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x25d6;
    L_0x25d0:
        r6 = new com.iqoption.d.fz;
        r6.<init>(r4, r5);
        return r6;
    L_0x25d6:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_card_processing_page is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x25ed:
        r6 = "layout/fragment_kyc_question_single_choice_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x25fb;
    L_0x25f5:
        r6 = new com.iqoption.d.no;
        r6.<init>(r4, r5);
        return r6;
    L_0x25fb:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_question_single_choice is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2612:
        r6 = "layout/fragment_vip_choose_time_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2620;
    L_0x261a:
        r6 = new com.iqoption.d.tw;
        r6.<init>(r4, r5);
        return r6;
    L_0x2620:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_vip_choose_time is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2637:
        r6 = "layout/layout_protected_old_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2645;
    L_0x263f:
        r6 = new com.iqoption.d.xc;
        r6.<init>(r4, r5);
        return r6;
    L_0x2645:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for layout_protected_old is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x265c:
        r6 = "layout/macro_feed_title_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x266a;
    L_0x2664:
        r6 = new com.iqoption.d.yr;
        r6.<init>(r4, r5);
        return r6;
    L_0x266a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for macro_feed_title is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2681:
        r6 = "layout/fragment_balance_selection_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x268f;
    L_0x2689:
        r6 = new com.iqoption.d.lk;
        r6.<init>(r4, r5);
        return r6;
    L_0x268f:
        r6 = "layout-xlarge-xhdpi/fragment_balance_selection_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x269d;
    L_0x2697:
        r6 = new com.iqoption.d.ll;
        r6.<init>(r4, r5);
        return r6;
    L_0x269d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_balance_selection is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x26b4:
        r6 = "layout/chat_fragment_search_room_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x26c2;
    L_0x26bc:
        r6 = new com.iqoption.d.df;
        r6.<init>(r4, r5);
        return r6;
    L_0x26c2:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_fragment_search_room is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x26d9:
        r6 = "layout/right_panel_delegate_cfd_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x26e7;
    L_0x26e1:
        r6 = new com.iqoption.d.ahl;
        r6.<init>(r4, r5);
        return r6;
    L_0x26e7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_cfd is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x26fe:
        r6 = "layout/fragment_balance_bar_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x270c;
    L_0x2706:
        r6 = new com.iqoption.d.li;
        r6.<init>(r4, r5);
        return r6;
    L_0x270c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_balance_bar is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2723:
        r6 = "layout/fragment_otn_leading_board_user_board_seen_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2731;
    L_0x272b:
        r6 = new com.iqoption.d.pu;
        r6.<init>(r4, r5);
        return r6;
    L_0x2731:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_otn_leading_board_user_board_seen is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2748:
        r6 = "layout/right_panel_delegate_crypto_success_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2756;
    L_0x2750:
        r6 = new com.iqoption.d.aif;
        r6.<init>(r4, r5);
        return r6;
    L_0x2756:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_crypto_success is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x276d:
        r6 = "layout/fragment_search_country_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x277b;
    L_0x2775:
        r6 = new com.iqoption.d.se;
        r6.<init>(r4, r5);
        return r6;
    L_0x277b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_search_country is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2792:
        r6 = "layout/portfolio_open_empty_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x27a0;
    L_0x279a:
        r6 = new com.iqoption.d.afk;
        r6.<init>(r4, r5);
        return r6;
    L_0x27a0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_open_empty_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x27b7:
        r6 = "layout/dialpad_key_touchid_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x27c5;
    L_0x27bf:
        r6 = new com.iqoption.d.kk;
        r6.<init>(r4, r5);
        return r6;
    L_0x27c5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialpad_key_touchid is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x27dc:
        r6 = "layout/fragment_margin_not_added_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x27ea;
    L_0x27e4:
        r6 = new com.iqoption.d.om;
        r6.<init>(r4, r5);
        return r6;
    L_0x27ea:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_margin_not_added is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2801:
        r6 = "layout/layout_pro_trader_benefits_top_row_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x280f;
    L_0x2809:
        r6 = new com.iqoption.d.xa;
        r6.<init>(r4, r5);
        return r6;
    L_0x280f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for layout_pro_trader_benefits_top_row is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2826:
        r6 = "layout/digital_expiration_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2834;
    L_0x282e:
        r6 = new com.iqoption.d.ko;
        r6.<init>(r4, r5);
        return r6;
    L_0x2834:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for digital_expiration_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x284b:
        r6 = "layout/fragment_otn_leading_board_user_board_commission_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2859;
    L_0x2853:
        r6 = new com.iqoption.d.po;
        r6.<init>(r4, r5);
        return r6;
    L_0x2859:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_otn_leading_board_user_board_commission is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2870:
        r6 = "layout/tools_content_active_tools_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x287e;
    L_0x2878:
        r6 = new com.iqoption.d.akn;
        r6.<init>(r4, r5);
        return r6;
    L_0x287e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for tools_content_active_tools is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2895:
        r6 = "layout-sw720dp/bg_chooser_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x28a3;
    L_0x289d:
        r6 = new com.iqoption.d.bb;
        r6.<init>(r4, r5);
        return r6;
    L_0x28a3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for bg_chooser_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x28ba:
        r6 = "layout/fragment_locale_asset_search_country_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x28c8;
    L_0x28c2:
        r6 = new com.iqoption.d.ok;
        r6.<init>(r4, r5);
        return r6;
    L_0x28c8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_locale_asset_search_country is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x28df:
        r6 = "layout/chat_image_message_body_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x28ed;
    L_0x28e7:
        r6 = new com.iqoption.d.dh;
        r6.<init>(r4, r5);
        return r6;
    L_0x28ed:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_image_message_body_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2904:
        r6 = "layout/fragment_promo_video_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2912;
    L_0x290c:
        r6 = new com.iqoption.d.qk;
        r6.<init>(r4, r5);
        return r6;
    L_0x2912:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_promo_video is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2929:
        r6 = "layout/vip_about_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2937;
    L_0x2931:
        r6 = new com.iqoption.d.alt;
        r6.<init>(r4, r5);
        return r6;
    L_0x2937:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for vip_about_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x294e:
        r6 = "layout/signal_latest_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x295c;
    L_0x2956:
        r6 = new com.iqoption.d.ajh;
        r6.<init>(r4, r5);
        return r6;
    L_0x295c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for signal_latest_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2973:
        r6 = "layout/fragment_video_education_searched_videos_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2981;
    L_0x297b:
        r6 = new com.iqoption.d.tq;
        r6.<init>(r4, r5);
        return r6;
    L_0x2981:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_video_education_searched_videos is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2998:
        r6 = "layout/dialog_pro_trader_benefits_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x29a6;
    L_0x29a0:
        r6 = new com.iqoption.d.jk;
        r6.<init>(r4, r5);
        return r6;
    L_0x29a6:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_pro_trader_benefits is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x29bd:
        r6 = "layout/portfolio_balance_otn_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x29cb;
    L_0x29c5:
        r6 = new com.iqoption.d.adv;
        r6.<init>(r4, r5);
        return r6;
    L_0x29cb:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_balance_otn is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x29e2:
        r6 = "layout/deposit_card_view_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x29f0;
    L_0x29ea:
        r6 = new com.iqoption.d.gb;
        r6.<init>(r4, r5);
        return r6;
    L_0x29f0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_card_view is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2a07:
        r6 = "layout/fragment_mkt_on_open_created_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2a15;
    L_0x2a0f:
        r6 = new com.iqoption.d.os;
        r6.<init>(r4, r5);
        return r6;
    L_0x2a15:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_mkt_on_open_created is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2a2c:
        r6 = "layout/item_country_suggest_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2a3a;
    L_0x2a34:
        r6 = new com.iqoption.d.vy;
        r6.<init>(r4, r5);
        return r6;
    L_0x2a3a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for item_country_suggest is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2a51:
        r6 = "layout/portfolio_exp_header_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2a5f;
    L_0x2a59:
        r6 = new com.iqoption.d.aeq;
        r6.<init>(r4, r5);
        return r6;
    L_0x2a5f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_exp_header_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2a76:
        r6 = "layout/micro_portfolio_cfd_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2a84;
    L_0x2a7e:
        r6 = new com.iqoption.d.zj;
        r6.<init>(r4, r5);
        return r6;
    L_0x2a84:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_cfd_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2a9b:
        r6 = "layout/fragment_withdrawal_crypto_pager_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2aa9;
    L_0x2aa3:
        r6 = new com.iqoption.d.vb;
        r6.<init>(r4, r5);
        return r6;
    L_0x2aa9:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_withdrawal_crypto_pager is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2ac0:
        r6 = "layout/fragment_video_education_videos_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2ace;
    L_0x2ac8:
        r6 = new com.iqoption.d.ts;
        r6.<init>(r4, r5);
        return r6;
    L_0x2ace:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_video_education_videos is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2ae5:
        r6 = "layout/session_title_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2af3;
    L_0x2aed:
        r6 = new com.iqoption.d.ajd;
        r6.<init>(r4, r5);
        return r6;
    L_0x2af3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for session_title is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2b0a:
        r6 = "layout/fragment_withdrawal_crypto_wallet_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2b18;
    L_0x2b12:
        r6 = new com.iqoption.d.vd;
        r6.<init>(r4, r5);
        return r6;
    L_0x2b18:
        r6 = "layout-land/fragment_withdrawal_crypto_wallet_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2b26;
    L_0x2b20:
        r6 = new com.iqoption.d.ve;
        r6.<init>(r4, r5);
        return r6;
    L_0x2b26:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_withdrawal_crypto_wallet is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2b3d:
        r6 = "layout/portfolio_exp_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2b4b;
    L_0x2b45:
        r6 = new com.iqoption.d.aeu;
        r6.<init>(r4, r5);
        return r6;
    L_0x2b4b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_exp_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2b62:
        r6 = "layout/right_panel_delegate_turbo_binary_call_put_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2b70;
    L_0x2b6a:
        r6 = new com.iqoption.d.air;
        r6.<init>(r4, r5);
        return r6;
    L_0x2b70:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_turbo_binary_call_put is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2b87:
        r6 = "layout/micro_portfolio_exp_header_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2b95;
    L_0x2b8f:
        r6 = new com.iqoption.d.zx;
        r6.<init>(r4, r5);
        return r6;
    L_0x2b95:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_exp_header_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2bac:
        r6 = "layout/open_cfd_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2bba;
    L_0x2bb4:
        r6 = new com.iqoption.d.acd;
        r6.<init>(r4, r5);
        return r6;
    L_0x2bba:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for open_cfd_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2bd1:
        r6 = "layout/right_panel_delegate_cfd_confirmation_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2bdf;
    L_0x2bd9:
        r6 = new com.iqoption.d.ahn;
        r6.<init>(r4, r5);
        return r6;
    L_0x2bdf:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_cfd_confirmation is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2bf6:
        r6 = "layout/whats_new_dialog_experimental_deposit_page_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2c04;
    L_0x2bfe:
        r6 = new com.iqoption.d.amd;
        r6.<init>(r4, r5);
        return r6;
    L_0x2c04:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for whats_new_dialog_experimental_deposit_page is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2c1b:
        r6 = "layout/kyc_toolbar_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2c29;
    L_0x2c23:
        r6 = new com.iqoption.d.ws;
        r6.<init>(r4, r5);
        return r6;
    L_0x2c29:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for kyc_toolbar_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2c40:
        r6 = "layout/local_toast_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2c4e;
    L_0x2c48:
        r6 = new com.iqoption.d.yl;
        r6.<init>(r4, r5);
        return r6;
    L_0x2c4e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for local_toast_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2c65:
        r6 = "layout/dialog_closed_deals_header_list_binary_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2c73;
    L_0x2c6d:
        r6 = new com.iqoption.d.hu;
        r6.<init>(r4, r5);
        return r6;
    L_0x2c73:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_closed_deals_header_list_binary is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2c8a:
        r6 = "layout/dialog_commision_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2c98;
    L_0x2c92:
        r6 = new com.iqoption.d.ig;
        r6.<init>(r4, r5);
        return r6;
    L_0x2c98:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_commision_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2caf:
        r6 = "layout/fragment_kyc_legal_name_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2cbd;
    L_0x2cb7:
        r6 = new com.iqoption.d.ne;
        r6.<init>(r4, r5);
        return r6;
    L_0x2cbd:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_legal_name is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2cd4:
        r6 = "layout/dialog_closed_deals_item_cfd_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2ce2;
    L_0x2cdc:
        r6 = new com.iqoption.d.ic;
        r6.<init>(r4, r5);
        return r6;
    L_0x2ce2:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_closed_deals_item_cfd is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2cf9:
        r6 = "layout/nps_completed_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2d07;
    L_0x2d01:
        r6 = new com.iqoption.d.abp;
        r6.<init>(r4, r5);
        return r6;
    L_0x2d07:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for nps_completed_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2d1e:
        r6 = "layout/fragment_quiz_question_language_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2d2c;
    L_0x2d26:
        r6 = new com.iqoption.d.rs;
        r6.<init>(r4, r5);
        return r6;
    L_0x2d2c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_question_language is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2d43:
        r6 = "layout/deposit_crypto_payment_method_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2d51;
    L_0x2d4b:
        r6 = new com.iqoption.d.gf;
        r6.<init>(r4, r5);
        return r6;
    L_0x2d51:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_crypto_payment_method_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2d68:
        r6 = "layout/base_smart_dialog_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2d76;
    L_0x2d70:
        r6 = new com.iqoption.d.aw;
        r6.<init>(r4, r5);
        return r6;
    L_0x2d76:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for base_smart_dialog_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2d8d:
        r6 = "layout/withdraw_limit_reason_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2d9b;
    L_0x2d95:
        r6 = new com.iqoption.d.amu;
        r6.<init>(r4, r5);
        return r6;
    L_0x2d9b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for withdraw_limit_reason_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2db2:
        r6 = "layout/bottom_sheet_otn_emission_history_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2dc0;
    L_0x2dba:
        r6 = new com.iqoption.d.bl;
        r6.<init>(r4, r5);
        return r6;
    L_0x2dc0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for bottom_sheet_otn_emission_history is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2dd7:
        r6 = "layout/fragment_pro_trader_active_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2de5;
    L_0x2ddf:
        r6 = new com.iqoption.d.qe;
        r6.<init>(r4, r5);
        return r6;
    L_0x2de5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_pro_trader_active is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2dfc:
        r6 = "layout/fragment_signals_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2e0a;
    L_0x2e04:
        r6 = new com.iqoption.d.sg;
        r6.<init>(r4, r5);
        return r6;
    L_0x2e0a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_signals is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2e21:
        r6 = "layout/dialog_closed_deals_item_cfd_aggregated_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2e2f;
    L_0x2e29:
        r6 = new com.iqoption.d.ia;
        r6.<init>(r4, r5);
        return r6;
    L_0x2e2f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_closed_deals_item_cfd_aggregated is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2e46:
        r6 = "layout/account_security_confirm_code_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2e54;
    L_0x2e4e:
        r6 = new com.iqoption.d.d;
        r6.<init>(r4, r5);
        return r6;
    L_0x2e54:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for account_security_confirm_code_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2e6b:
        r6 = "layout/feed_options_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2e79;
    L_0x2e73:
        r6 = new com.iqoption.d.ku;
        r6.<init>(r4, r5);
        return r6;
    L_0x2e79:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for feed_options is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2e90:
        r6 = "layout/fragment_kyc_email_confirm_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2e9e;
    L_0x2e98:
        r6 = new com.iqoption.d.mu;
        r6.<init>(r4, r5);
        return r6;
    L_0x2e9e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_email_confirm is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2eb5:
        r6 = "layout/string_basket_remove_all_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2ec3;
    L_0x2ebd:
        r6 = new com.iqoption.d.ajz;
        r6.<init>(r4, r5);
        return r6;
    L_0x2ec3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for string_basket_remove_all_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2eda:
        r6 = "layout/chat_like_dislike_message_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2ee8;
    L_0x2ee2:
        r6 = new com.iqoption.d.dr;
        r6.<init>(r4, r5);
        return r6;
    L_0x2ee8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_like_dislike_message_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2eff:
        r6 = "layout/dialog_congrat_otn_emission_executed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2f0d;
    L_0x2f07:
        r6 = new com.iqoption.d.im;
        r6.<init>(r4, r5);
        return r6;
    L_0x2f0d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_congrat_otn_emission_executed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2f24:
        r6 = "layout/layout_welcome_policy_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2f32;
    L_0x2f2c:
        r6 = new com.iqoption.d.xe;
        r6.<init>(r4, r5);
        return r6;
    L_0x2f32:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for layout_welcome_policy is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2f49:
        r6 = "layout/fragment_quiz_leaderboard_filter_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2f57;
    L_0x2f51:
        r6 = new com.iqoption.d.rc;
        r6.<init>(r4, r5);
        return r6;
    L_0x2f57:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_leaderboard_filter is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2f6e:
        r6 = "layout/active_tools_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2f7c;
    L_0x2f76:
        r6 = new com.iqoption.d.aa;
        r6.<init>(r4, r5);
        return r6;
    L_0x2f7c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for active_tools_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2f93:
        r6 = "layout/macro_video_feed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2fa1;
    L_0x2f9b:
        r6 = new com.iqoption.d.yx;
        r6.<init>(r4, r5);
        return r6;
    L_0x2fa1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for macro_video_feed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2fb8:
        r6 = "layout/fragment_kyc_date_of_birth_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2fc6;
    L_0x2fc0:
        r6 = new com.iqoption.d.mk;
        r6.<init>(r4, r5);
        return r6;
    L_0x2fc6:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_date_of_birth is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x2fdd:
        r6 = "layout/micro_portfolio_page_open_positions_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x2feb;
    L_0x2fe5:
        r6 = new com.iqoption.d.aap;
        r6.<init>(r4, r5);
        return r6;
    L_0x2feb:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_page_open_positions is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3002:
        r6 = "layout/dialog_closed_deals_header_cfd_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3010;
    L_0x300a:
        r6 = new com.iqoption.d.hq;
        r6.<init>(r4, r5);
        return r6;
    L_0x3010:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_closed_deals_header_cfd is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3027:
        r6 = "layout/fragment_token_balance_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3035;
    L_0x302f:
        r6 = new com.iqoption.d.sk;
        r6.<init>(r4, r5);
        return r6;
    L_0x3035:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_token_balance is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x304c:
        r6 = "layout/open_digital_option_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x305a;
    L_0x3054:
        r6 = new com.iqoption.d.acj;
        r6.<init>(r4, r5);
        return r6;
    L_0x305a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for open_digital_option_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3071:
        r6 = "layout/withdraw_history_payout_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x307f;
    L_0x3079:
        r6 = new com.iqoption.d.amo;
        r6.<init>(r4, r5);
        return r6;
    L_0x307f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for withdraw_history_payout_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3096:
        r6 = "layout/dialog_closed_deals_header_list_do_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x30a4;
    L_0x309e:
        r6 = new com.iqoption.d.hy;
        r6.<init>(r4, r5);
        return r6;
    L_0x30a4:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_closed_deals_header_list_do is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x30bb:
        r6 = "layout-land/fragment_operation_history_options_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x30c9;
    L_0x30c3:
        r6 = new com.iqoption.d.pf;
        r6.<init>(r4, r5);
        return r6;
    L_0x30c9:
        r6 = "layout/fragment_operation_history_options_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x30d7;
    L_0x30d1:
        r6 = new com.iqoption.d.pe;
        r6.<init>(r4, r5);
        return r6;
    L_0x30d7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_operation_history_options is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x30ee:
        r6 = "layout/splash_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3100;
    L_0x30f6:
        r6 = new com.iqoption.d.ajr;
        r0 = new android.view.View[r2];
        r0[r1] = r5;
        r6.<init>(r4, r0);
        return r6;
    L_0x3100:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for splash is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3117:
        r6 = "layout/dialog_otn_expectation_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3125;
    L_0x311f:
        r6 = new com.iqoption.d.iy;
        r6.<init>(r4, r5);
        return r6;
    L_0x3125:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_otn_expectation is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x313c:
        r6 = "layout/withdraw_field_constructor_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x314a;
    L_0x3144:
        r6 = new com.iqoption.d.aml;
        r6.<init>(r4, r5);
        return r6;
    L_0x314a:
        r6 = "layout-land/withdraw_field_constructor_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3158;
    L_0x3152:
        r6 = new com.iqoption.d.amm;
        r6.<init>(r4, r5);
        return r6;
    L_0x3158:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for withdraw_field_constructor is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x316f:
        r6 = "layout/fragment_kyc_acceptable_documents_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x317d;
    L_0x3177:
        r6 = new com.iqoption.d.lw;
        r6.<init>(r4, r5);
        return r6;
    L_0x317d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_acceptable_documents is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3194:
        r6 = "layout/chat_file_message_head_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x31a2;
    L_0x319c:
        r6 = new com.iqoption.d.cp;
        r6.<init>(r4, r5);
        return r6;
    L_0x31a2:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_file_message_head_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x31b9:
        r6 = "layout/operation_search_result_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x31c7;
    L_0x31c1:
        r6 = new com.iqoption.d.acr;
        r6.<init>(r4, r5);
        return r6;
    L_0x31c7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for operation_search_result_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x31de:
        r6 = "layout/portfolio_filter_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x31ec;
    L_0x31e6:
        r6 = new com.iqoption.d.aey;
        r6.<init>(r4, r5);
        return r6;
    L_0x31ec:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_filter_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3203:
        r6 = "layout/keyboard_tpsl_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3211;
    L_0x320b:
        r6 = new com.iqoption.d.wo;
        r6.<init>(r4, r5);
        return r6;
    L_0x3211:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for keyboard_tpsl is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3228:
        r6 = "layout/chat_fragment_attachment_picker_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3236;
    L_0x3230:
        r6 = new com.iqoption.d.cx;
        r6.<init>(r4, r5);
        return r6;
    L_0x3236:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_fragment_attachment_picker is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x324d:
        r6 = "layout/indicator_info_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x325b;
    L_0x3255:
        r6 = new com.iqoption.d.vq;
        r6.<init>(r4, r5);
        return r6;
    L_0x325b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for indicator_info_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3272:
        r6 = "layout/dialog_portfolio_invest_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3280;
    L_0x327a:
        r6 = new com.iqoption.d.jg;
        r6.<init>(r4, r5);
        return r6;
    L_0x3280:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_portfolio_invest_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3297:
        r6 = "layout/chat_room_cant_send_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x32a5;
    L_0x329f:
        r6 = new com.iqoption.d.eb;
        r6.<init>(r4, r5);
        return r6;
    L_0x32a5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_room_cant_send_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x32bc:
        r6 = "layout/fragment_kyc_address_declined_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x32ca;
    L_0x32c4:
        r6 = new com.iqoption.d.ma;
        r6.<init>(r4, r5);
        return r6;
    L_0x32ca:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_address_declined is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x32e1:
        r6 = "layout/item_welcome_trending_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x32ef;
    L_0x32e9:
        r6 = new com.iqoption.d.wk;
        r6.<init>(r4, r5);
        return r6;
    L_0x32ef:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for item_welcome_trending is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3306:
        r6 = "layout/fragment_kyc_email_confirmed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3314;
    L_0x330e:
        r6 = new com.iqoption.d.mw;
        r6.<init>(r4, r5);
        return r6;
    L_0x3314:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_email_confirmed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x332b:
        r6 = "layout/micro_portfolio_open_empty_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3339;
    L_0x3333:
        r6 = new com.iqoption.d.aaj;
        r6.<init>(r4, r5);
        return r6;
    L_0x3339:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_open_empty_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3350:
        r6 = "layout/price_movements_filter_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x335e;
    L_0x3358:
        r6 = new com.iqoption.d.agl;
        r6.<init>(r4, r5);
        return r6;
    L_0x335e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for price_movements_filter_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3375:
        r6 = "layout/chat_text_message_full_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3383;
    L_0x337d:
        r6 = new com.iqoption.d.er;
        r6.<init>(r4, r5);
        return r6;
    L_0x3383:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_text_message_full_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x339a:
        r6 = "layout/smart_feed_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x33a8;
    L_0x33a2:
        r6 = new com.iqoption.d.ajp;
        r6.<init>(r4, r5);
        return r6;
    L_0x33a8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for smart_feed_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x33bf:
        r6 = "layout/left_menu_item_terms_and_conditions_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x33cd;
    L_0x33c7:
        r6 = new com.iqoption.d.yf;
        r6.<init>(r4, r5);
        return r6;
    L_0x33cd:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item_terms_and_conditions is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x33e4:
        r6 = "layout/portfolio_page_open_positions_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x33f2;
    L_0x33ec:
        r6 = new com.iqoption.d.afo;
        r6.<init>(r4, r5);
        return r6;
    L_0x33f2:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_page_open_positions is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3409:
        r6 = "layout/portfolio_pending_single_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3417;
    L_0x3411:
        r6 = new com.iqoption.d.agc;
        r6.<init>(r4, r5);
        return r6;
    L_0x3417:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_pending_single_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x342e:
        r6 = "layout/account_security_resend_email_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x343c;
    L_0x3436:
        r6 = new com.iqoption.d.r;
        r6.<init>(r4, r5);
        return r6;
    L_0x343c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for account_security_resend_email_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3453:
        r6 = "layout/portfolio_cfd_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3461;
    L_0x345b:
        r6 = new com.iqoption.d.aeb;
        r6.<init>(r4, r5);
        return r6;
    L_0x3461:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_cfd_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3478:
        r6 = "layout/fragment_micro_room_list_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3486;
    L_0x3480:
        r6 = new com.iqoption.d.oq;
        r6.<init>(r4, r5);
        return r6;
    L_0x3486:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_micro_room_list is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x349d:
        r6 = "layout/fragment_multiplier_chooser_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x34ab;
    L_0x34a5:
        r6 = new com.iqoption.d.ou;
        r6.<init>(r4, r5);
        return r6;
    L_0x34ab:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_multiplier_chooser is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x34c2:
        r6 = "layout/open_digital_option_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x34d0;
    L_0x34ca:
        r6 = new com.iqoption.d.acl;
        r6.<init>(r4, r5);
        return r6;
    L_0x34d0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for open_digital_option_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x34e7:
        r6 = "layout/fragment_welcome_onboarding_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x34f5;
    L_0x34ef:
        r6 = new com.iqoption.d.uf;
        r6.<init>(r4, r5);
        return r6;
    L_0x34f5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_welcome_onboarding is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x350c:
        r6 = "layout/news_and_updates_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x351a;
    L_0x3514:
        r6 = new com.iqoption.d.abn;
        r6.<init>(r4, r5);
        return r6;
    L_0x351a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for news_and_updates_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3531:
        r6 = "layout/rate_us_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x353f;
    L_0x3539:
        r6 = new com.iqoption.d.ahh;
        r6.<init>(r4, r5);
        return r6;
    L_0x353f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for rate_us_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3556:
        r6 = "layout/price_movements_attention_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3564;
    L_0x355e:
        r6 = new com.iqoption.d.agj;
        r6.<init>(r4, r5);
        return r6;
    L_0x3564:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for price_movements_attention is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x357b:
        r6 = "layout/numpad_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3589;
    L_0x3583:
        r6 = new com.iqoption.d.abv;
        r6.<init>(r4, r5);
        return r6;
    L_0x3589:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for numpad is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x35a0:
        r6 = "layout/micro_portfolio_total_pager_page_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x35ae;
    L_0x35a8:
        r6 = new com.iqoption.d.abd;
        r6.<init>(r4, r5);
        return r6;
    L_0x35ae:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_total_pager_page is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x35c5:
        r6 = "layout/bottom_sheet_chooser_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x35d3;
    L_0x35cd:
        r6 = new com.iqoption.d.bf;
        r6.<init>(r4, r5);
        return r6;
    L_0x35d3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for bottom_sheet_chooser is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x35ea:
        r6 = "layout/micro_portfolio_pending_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x35f8;
    L_0x35f2:
        r6 = new com.iqoption.d.aax;
        r6.<init>(r4, r5);
        return r6;
    L_0x35f8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_pending_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x360f:
        r6 = "layout/deposit_payment_completed_page_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x361d;
    L_0x3617:
        r6 = new com.iqoption.d.he;
        r6.<init>(r4, r5);
        return r6;
    L_0x361d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_payment_completed_page is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3634:
        r6 = "layout/fragment_kyc_risks_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3642;
    L_0x363c:
        r6 = new com.iqoption.d.oc;
        r6.<init>(r4, r5);
        return r6;
    L_0x3642:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_risks is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3659:
        r6 = "layout/fragment_welcome_trending_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3667;
    L_0x3661:
        r6 = new com.iqoption.d.uj;
        r6.<init>(r4, r5);
        return r6;
    L_0x3667:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_welcome_trending is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x367e:
        r6 = "layout/video_education_video_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x368c;
    L_0x3686:
        r6 = new com.iqoption.d.alp;
        r6.<init>(r4, r5);
        return r6;
    L_0x368c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for video_education_video_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x36a3:
        r6 = "layout/dialog_pro_application_status_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x36b1;
    L_0x36ab:
        r6 = new com.iqoption.d.ji;
        r6.<init>(r4, r5);
        return r6;
    L_0x36b1:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_pro_application_status is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x36c8:
        r6 = "layout/fragment_withdraw_verify_page_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x36d6;
    L_0x36d0:
        r6 = new com.iqoption.d.uv;
        r6.<init>(r4, r5);
        return r6;
    L_0x36d6:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_withdraw_verify_page is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x36ed:
        r6 = "layout/fragment_kyc_email_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x36fb;
    L_0x36f5:
        r6 = new com.iqoption.d.ms;
        r6.<init>(r4, r5);
        return r6;
    L_0x36fb:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_email is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3712:
        r6 = "layout/item_overnight_fee_schedule_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3720;
    L_0x371a:
        r6 = new com.iqoption.d.wg;
        r6.<init>(r4, r5);
        return r6;
    L_0x3720:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for item_overnight_fee_schedule is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3737:
        r6 = "layout/operation_history_single_selection_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3745;
    L_0x373f:
        r6 = new com.iqoption.d.acp;
        r6.<init>(r4, r5);
        return r6;
    L_0x3745:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for operation_history_single_selection is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x375c:
        r6 = "layout/item_locale_asset_country_suggest_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x376a;
    L_0x3764:
        r6 = new com.iqoption.d.we;
        r6.<init>(r4, r5);
        return r6;
    L_0x376a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for item_locale_asset_country_suggest is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3781:
        r6 = "layout/fragment_otn_leading_board_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x378f;
    L_0x3789:
        r6 = new com.iqoption.d.pk;
        r6.<init>(r4, r5);
        return r6;
    L_0x378f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_otn_leading_board is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x37a6:
        r6 = "layout/tools_content_templates_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x37b4;
    L_0x37ae:
        r6 = new com.iqoption.d.akt;
        r6.<init>(r4, r5);
        return r6;
    L_0x37b4:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for tools_content_templates is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x37cb:
        r6 = "layout/vip_education_item_view_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x37d9;
    L_0x37d3:
        r6 = new com.iqoption.d.alv;
        r6.<init>(r4, r5);
        return r6;
    L_0x37d9:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for vip_education_item_view is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x37f0:
        r6 = "layout/left_menu_item_list_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x37fe;
    L_0x37f8:
        r6 = new com.iqoption.d.xv;
        r6.<init>(r4, r5);
        return r6;
    L_0x37fe:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item_list is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3815:
        r6 = "layout/high_frequency_panel_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3823;
    L_0x381d:
        r6 = new com.iqoption.d.vm;
        r6.<init>(r4, r5);
        return r6;
    L_0x3823:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for high_frequency_panel_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x383a:
        r6 = "layout/activity_pro_deposit_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3848;
    L_0x3842:
        r6 = new com.iqoption.d.ag;
        r6.<init>(r4, r5);
        return r6;
    L_0x3848:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for activity_pro_deposit is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x385f:
        r6 = "layout/fragment_kyc_cysec_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x386d;
    L_0x3867:
        r6 = new com.iqoption.d.mi;
        r6.<init>(r4, r5);
        return r6;
    L_0x386d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_cysec is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3884:
        r6 = "layout/tools_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3892;
    L_0x388c:
        r6 = new com.iqoption.d.akv;
        r6.<init>(r4, r5);
        return r6;
    L_0x3892:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for tools_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x38a9:
        r6 = "layout/string_save_as_tamplet_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x38b7;
    L_0x38b1:
        r6 = new com.iqoption.d.akd;
        r6.<init>(r4, r5);
        return r6;
    L_0x38b7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for string_save_as_tamplet is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x38ce:
        r6 = "layout/fragment_pro_trader_more_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x38dc;
    L_0x38d6:
        r6 = new com.iqoption.d.qg;
        r6.<init>(r4, r5);
        return r6;
    L_0x38dc:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_pro_trader_more is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x38f3:
        r6 = "layout/fragment_quiz_update_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3901;
    L_0x38fb:
        r6 = new com.iqoption.d.rw;
        r6.<init>(r4, r5);
        return r6;
    L_0x3901:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_update_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3918:
        r6 = "layout/micro_portfolio_exp_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3926;
    L_0x3920:
        r6 = new com.iqoption.d.zv;
        r6.<init>(r4, r5);
        return r6;
    L_0x3926:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_exp_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x393d:
        r6 = "layout/whats_new_dialog_templates_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x394b;
    L_0x3945:
        r6 = new com.iqoption.d.amh;
        r6.<init>(r4, r5);
        return r6;
    L_0x394b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for whats_new_dialog_templates is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3962:
        r6 = "layout/fragment_verify_status_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3970;
    L_0x396a:
        r6 = new com.iqoption.d.tm;
        r6.<init>(r4, r5);
        return r6;
    L_0x3970:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_verify_status is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3987:
        r6 = "layout-sw600dp/deposit_page_content_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3995;
    L_0x398f:
        r6 = new com.iqoption.d.gs;
        r6.<init>(r4, r5);
        return r6;
    L_0x3995:
        r6 = "layout/deposit_page_content_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x39a3;
    L_0x399d:
        r6 = new com.iqoption.d.gr;
        r6.<init>(r4, r5);
        return r6;
    L_0x39a3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_page_content is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x39ba:
        r6 = "layout/micro_tweet_feed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x39c8;
    L_0x39c2:
        r6 = new com.iqoption.d.abh;
        r6.<init>(r4, r5);
        return r6;
    L_0x39c8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_tweet_feed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x39df:
        r6 = "layout/instrument_type_bottom_sheet_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x39ed;
    L_0x39e7:
        r6 = new com.iqoption.d.vu;
        r6.<init>(r4, r5);
        return r6;
    L_0x39ed:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for instrument_type_bottom_sheet_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3a04:
        r6 = "layout/session_other_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3a12;
    L_0x3a0c:
        r6 = new com.iqoption.d.ajb;
        r6.<init>(r4, r5);
        return r6;
    L_0x3a12:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for session_other_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3a29:
        r6 = "layout-land/active_sessions_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3a37;
    L_0x3a31:
        r6 = new com.iqoption.d.y;
        r6.<init>(r4, r5);
        return r6;
    L_0x3a37:
        r6 = "layout/active_sessions_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3a45;
    L_0x3a3f:
        r6 = new com.iqoption.d.x;
        r6.<init>(r4, r5);
        return r6;
    L_0x3a45:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for active_sessions_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3a5c:
        r6 = "layout/fragment_quiz_off_air_title_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3a6a;
    L_0x3a64:
        r6 = new com.iqoption.d.rm;
        r6.<init>(r4, r5);
        return r6;
    L_0x3a6a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_off_air_title is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3a81:
        r6 = "layout/micro_article_feed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3a8f;
    L_0x3a89:
        r6 = new com.iqoption.d.zb;
        r6.<init>(r4, r5);
        return r6;
    L_0x3a8f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_article_feed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3aa6:
        r6 = "layout/dialog_pro_trader_selected_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3ab4;
    L_0x3aae:
        r6 = new com.iqoption.d.jm;
        r6.<init>(r4, r5);
        return r6;
    L_0x3ab4:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_pro_trader_selected is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3acb:
        r6 = "layout/video_education_simple_category_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3ad9;
    L_0x3ad3:
        r6 = new com.iqoption.d.all;
        r6.<init>(r4, r5);
        return r6;
    L_0x3ad9:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for video_education_simple_category_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3af0:
        r6 = "layout/portfolio_mkt_on_open_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3afe;
    L_0x3af8:
        r6 = new com.iqoption.d.afg;
        r6.<init>(r4, r5);
        return r6;
    L_0x3afe:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_mkt_on_open_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3b15:
        r6 = "layout/bottom_sheet_portfolio_tpsl_chooser_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3b23;
    L_0x3b1d:
        r6 = new com.iqoption.d.br;
        r6.<init>(r4, r5);
        return r6;
    L_0x3b23:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for bottom_sheet_portfolio_tpsl_chooser is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3b3a:
        r6 = "layout/chat_file_picker_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3b48;
    L_0x3b42:
        r6 = new com.iqoption.d.cv;
        r6.<init>(r4, r5);
        return r6;
    L_0x3b48:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_file_picker_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3b5f:
        r6 = "layout/right_panel_delegate_digital_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3b6d;
    L_0x3b67:
        r6 = new com.iqoption.d.aih;
        r6.<init>(r4, r5);
        return r6;
    L_0x3b6d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_digital is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3b84:
        r6 = "layout/chat_image_message_tail_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3b92;
    L_0x3b8c:
        r6 = new com.iqoption.d.dn;
        r6.<init>(r4, r5);
        return r6;
    L_0x3b92:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_image_message_tail_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3ba9:
        r6 = "layout/portfolio_app_bar_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3bb7;
    L_0x3bb1:
        r6 = new com.iqoption.d.adr;
        r6.<init>(r4, r5);
        return r6;
    L_0x3bb7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_app_bar is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3bce:
        r6 = "layout/left_menu_item_with_progress_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3bdc;
    L_0x3bd6:
        r6 = new com.iqoption.d.yh;
        r6.<init>(r4, r5);
        return r6;
    L_0x3bdc:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item_with_progress is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3bf3:
        r6 = "layout/portfolio_exp_single_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3c01;
    L_0x3bfb:
        r6 = new com.iqoption.d.aew;
        r6.<init>(r4, r5);
        return r6;
    L_0x3c01:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_exp_single_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3c18:
        r6 = "layout/deposit_old_amount_line_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3c26;
    L_0x3c20:
        r6 = new com.iqoption.d.gl;
        r6.<init>(r4, r5);
        return r6;
    L_0x3c26:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_old_amount_line is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3c3d:
        r6 = "layout/signal_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3c4b;
    L_0x3c45:
        r6 = new com.iqoption.d.ajf;
        r6.<init>(r4, r5);
        return r6;
    L_0x3c4b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for signal_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3c62:
        r6 = "layout/fragment_kyc_finish_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3c70;
    L_0x3c6a:
        r6 = new com.iqoption.d.my;
        r6.<init>(r4, r5);
        return r6;
    L_0x3c70:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_finish is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3c87:
        r6 = "layout/fragment_kyc_phone_confirmed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3c95;
    L_0x3c8f:
        r6 = new com.iqoption.d.nk;
        r6.<init>(r4, r5);
        return r6;
    L_0x3c95:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_phone_confirmed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3cac:
        r6 = "layout/chat_text_message_body_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3cba;
    L_0x3cb4:
        r6 = new com.iqoption.d.ep;
        r6.<init>(r4, r5);
        return r6;
    L_0x3cba:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_text_message_body_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3cd1:
        r6 = "layout/fragment_account_security_passcode_error_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3cdf;
    L_0x3cd9:
        r6 = new com.iqoption.d.lg;
        r6.<init>(r4, r5);
        return r6;
    L_0x3cdf:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_account_security_passcode_error is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3cf6:
        r6 = "layout/confirm_dialog_view_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3d04;
    L_0x3cfe:
        r6 = new com.iqoption.d.fr;
        r6.<init>(r4, r5);
        return r6;
    L_0x3d04:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for confirm_dialog_view is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3d1b:
        r6 = "layout/string_basket_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3d29;
    L_0x3d23:
        r6 = new com.iqoption.d.ajx;
        r6.<init>(r4, r5);
        return r6;
    L_0x3d29:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for string_basket_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3d40:
        r6 = "layout/otn_leader_board_current_user_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3d4e;
    L_0x3d48:
        r6 = new com.iqoption.d.acv;
        r6.<init>(r4, r5);
        return r6;
    L_0x3d4e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for otn_leader_board_current_user_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3d65:
        r6 = "layout/portfolio_micro_filter_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3d73;
    L_0x3d6d:
        r6 = new com.iqoption.d.afe;
        r6.<init>(r4, r5);
        return r6;
    L_0x3d73:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_micro_filter_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3d8a:
        r6 = "layout/right_panel_delegate_digital_call_put_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3d98;
    L_0x3d92:
        r6 = new com.iqoption.d.aij;
        r6.<init>(r4, r5);
        return r6;
    L_0x3d98:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_digital_call_put is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3daf:
        r6 = "layout/right_panel_delegate_cfd_main_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3dbd;
    L_0x3db7:
        r6 = new com.iqoption.d.ahp;
        r6.<init>(r4, r5);
        return r6;
    L_0x3dbd:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_cfd_main is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3dd4:
        r6 = "layout/fragment_pending_order_executed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3de2;
    L_0x3ddc:
        r6 = new com.iqoption.d.qc;
        r6.<init>(r4, r5);
        return r6;
    L_0x3de2:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_pending_order_executed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3df9:
        r6 = "layout/dialog_closed_deals_item_do_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3e07;
    L_0x3e01:
        r6 = new com.iqoption.d.ie;
        r6.<init>(r4, r5);
        return r6;
    L_0x3e07:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_closed_deals_item_do is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3e1e:
        r6 = "layout/chat_room_private_toolbar_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3e2c;
    L_0x3e26:
        r6 = new com.iqoption.d.ed;
        r6.<init>(r4, r5);
        return r6;
    L_0x3e2c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_room_private_toolbar is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3e43:
        r6 = "layout/dialpad_dot_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3e51;
    L_0x3e4b:
        r6 = new com.iqoption.d.ke;
        r6.<init>(r4, r5);
        return r6;
    L_0x3e51:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialpad_dot is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3e68:
        r6 = "layout/fragment_withdrawal_crypto_kyc_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3e76;
    L_0x3e70:
        r6 = new com.iqoption.d.uz;
        r6.<init>(r4, r5);
        return r6;
    L_0x3e76:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_withdrawal_crypto_kyc is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3e8d:
        r6 = "layout/price_movements_high_frequency_layout_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3e9b;
    L_0x3e95:
        r6 = new com.iqoption.d.agv;
        r6.<init>(r4, r5);
        return r6;
    L_0x3e9b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for price_movements_high_frequency_layout is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3eb2:
        r6 = "layout/dialog_confirm_close_pending_position_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3ec0;
    L_0x3eba:
        r6 = new com.iqoption.d.ii;
        r6.<init>(r4, r5);
        return r6;
    L_0x3ec0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_confirm_close_pending_position is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3ed7:
        r6 = "layout/micro_feed_title_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3ee5;
    L_0x3edf:
        r6 = new com.iqoption.d.zf;
        r6.<init>(r4, r5);
        return r6;
    L_0x3ee5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_feed_title is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3efc:
        r6 = "layout/fragment_right_panel_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3f0a;
    L_0x3f04:
        r6 = new com.iqoption.d.ry;
        r6.<init>(r4, r5);
        return r6;
    L_0x3f0a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_right_panel is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3f21:
        r6 = "layout/fragment_otn_leading_board_user_board_trading_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3f2f;
    L_0x3f29:
        r6 = new com.iqoption.d.pw;
        r6.<init>(r4, r5);
        return r6;
    L_0x3f2f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_otn_leading_board_user_board_trading is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3f46:
        r6 = "layout/portfolio_pending_empty_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3f54;
    L_0x3f4e:
        r6 = new com.iqoption.d.afs;
        r6.<init>(r4, r5);
        return r6;
    L_0x3f54:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_pending_empty_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3f6b:
        r6 = "layout/kdj_dialog_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3f79;
    L_0x3f73:
        r6 = new com.iqoption.d.wm;
        r6.<init>(r4, r5);
        return r6;
    L_0x3f79:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for kdj_dialog is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3f90:
        r6 = "layout/fragment_kyc_question_multi_choice_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3f9e;
    L_0x3f98:
        r6 = new com.iqoption.d.nm;
        r6.<init>(r4, r5);
        return r6;
    L_0x3f9e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_question_multi_choice is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3fb5:
        r6 = "layout/fragment_trading_history_set_asset_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3fc3;
    L_0x3fbd:
        r6 = new com.iqoption.d.sy;
        r6.<init>(r4, r5);
        return r6;
    L_0x3fc3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_trading_history_set_asset is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3fda:
        r6 = "layout/withdraw_verify_button_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x3fe8;
    L_0x3fe2:
        r6 = new com.iqoption.d.amy;
        r6.<init>(r4, r5);
        return r6;
    L_0x3fe8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for withdraw_verify_button is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x3fff:
        r6 = "layout/open_cfd_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x400d;
    L_0x4007:
        r6 = new com.iqoption.d.acf;
        r6.<init>(r4, r5);
        return r6;
    L_0x400d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for open_cfd_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4024:
        r6 = "layout/micro_portfolio_cfd_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4032;
    L_0x402c:
        r6 = new com.iqoption.d.zn;
        r6.<init>(r4, r5);
        return r6;
    L_0x4032:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_cfd_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4049:
        r6 = "layout/fragment_account_security_passcode_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4057;
    L_0x4051:
        r6 = new com.iqoption.d.le;
        r6.<init>(r4, r5);
        return r6;
    L_0x4057:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_account_security_passcode is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x406e:
        r6 = "layout/chat_room_public_toolbar_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x407c;
    L_0x4076:
        r6 = new com.iqoption.d.ef;
        r6.<init>(r4, r5);
        return r6;
    L_0x407c:
        r6 = "layout-land/chat_room_public_toolbar_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x408a;
    L_0x4084:
        r6 = new com.iqoption.d.eg;
        r6.<init>(r4, r5);
        return r6;
    L_0x408a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_room_public_toolbar is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x40a1:
        r6 = "layout/dialog_confirm_sell_position_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x40af;
    L_0x40a9:
        r6 = new com.iqoption.d.ik;
        r6.<init>(r4, r5);
        return r6;
    L_0x40af:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_confirm_sell_position is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x40c6:
        r6 = "layout/fragment_kyc_documents_intro_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x40d4;
    L_0x40ce:
        r6 = new com.iqoption.d.mo;
        r6.<init>(r4, r5);
        return r6;
    L_0x40d4:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_documents_intro is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x40eb:
        r6 = "layout/micro_portfolio_page_closed_positions_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x40f9;
    L_0x40f3:
        r6 = new com.iqoption.d.aan;
        r6.<init>(r4, r5);
        return r6;
    L_0x40f9:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_page_closed_positions is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4110:
        r6 = "layout/macro_feed_options_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x411e;
    L_0x4118:
        r6 = new com.iqoption.d.yp;
        r6.<init>(r4, r5);
        return r6;
    L_0x411e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for macro_feed_options is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4135:
        r6 = "layout/dialog_quiz_user_profile_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4143;
    L_0x413d:
        r6 = new com.iqoption.d.jo;
        r6.<init>(r4, r5);
        return r6;
    L_0x4143:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_quiz_user_profile is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x415a:
        r6 = "layout/deposit_card_back_side_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4168;
    L_0x4162:
        r6 = new com.iqoption.d.fv;
        r6.<init>(r4, r5);
        return r6;
    L_0x4168:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_card_back_side is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x417f:
        r6 = "layout/micro_other_video_feed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x418d;
    L_0x4187:
        r6 = new com.iqoption.d.zh;
        r6.<init>(r4, r5);
        return r6;
    L_0x418d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_other_video_feed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x41a4:
        r6 = "layout/tools_content_settings_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x41b2;
    L_0x41ac:
        r6 = new com.iqoption.d.akr;
        r6.<init>(r4, r5);
        return r6;
    L_0x41b2:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for tools_content_settings is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x41c9:
        r6 = "layout/strike_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x41d7;
    L_0x41d1:
        r6 = new com.iqoption.d.ajt;
        r6.<init>(r4, r5);
        return r6;
    L_0x41d7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for strike_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x41ee:
        r6 = "layout/fragment_trading_history_search_setting_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x41fc;
    L_0x41f6:
        r6 = new com.iqoption.d.sw;
        r6.<init>(r4, r5);
        return r6;
    L_0x41fc:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_trading_history_search_setting is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4213:
        r6 = "layout/fragment_traderoom_restriction_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4221;
    L_0x421b:
        r6 = new com.iqoption.d.so;
        r6.<init>(r4, r5);
        return r6;
    L_0x4221:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_traderoom_restriction is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4238:
        r6 = "layout/fragment_left_panel_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4246;
    L_0x4240:
        r6 = new com.iqoption.d.oi;
        r6.<init>(r4, r5);
        return r6;
    L_0x4246:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_left_panel is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x425d:
        r6 = "layout/price_movements_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x426b;
    L_0x4265:
        r6 = new com.iqoption.d.agr;
        r6.<init>(r4, r5);
        return r6;
    L_0x426b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for price_movements_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4282:
        r6 = "layout/deposit_payment_method_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4290;
    L_0x428a:
        r6 = new com.iqoption.d.hg;
        r6.<init>(r4, r5);
        return r6;
    L_0x4290:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_payment_method_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x42a7:
        r6 = "layout/fragment_quiz_leaderboard_filter_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x42b5;
    L_0x42af:
        r6 = new com.iqoption.d.re;
        r6.<init>(r4, r5);
        return r6;
    L_0x42b5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_quiz_leaderboard_filter_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x42cc:
        r6 = "layout/commission_view_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x42de;
    L_0x42d4:
        r6 = new com.iqoption.d.fp;
        r0 = new android.view.View[r2];
        r0[r1] = r5;
        r6.<init>(r4, r0);
        return r6;
    L_0x42de:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for commission_view is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x42f5:
        r6 = "layout/account_security_confirm_code_expired_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4303;
    L_0x42fd:
        r6 = new com.iqoption.d.b;
        r6.<init>(r4, r5);
        return r6;
    L_0x4303:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for account_security_confirm_code_expired_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x431a:
        r6 = "layout/dialpad_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4328;
    L_0x4322:
        r6 = new com.iqoption.d.kc;
        r6.<init>(r4, r5);
        return r6;
    L_0x4328:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialpad is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x433f:
        r6 = "layout/left_menu_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x434d;
    L_0x4347:
        r6 = new com.iqoption.d.xj;
        r6.<init>(r4, r5);
        return r6;
    L_0x434d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for left_menu_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4364:
        r6 = "layout/base_smart_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4372;
    L_0x436c:
        r6 = new com.iqoption.d.ay;
        r6.<init>(r4, r5);
        return r6;
    L_0x4372:
        r6 = "layout-sw720dp/base_smart_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4380;
    L_0x437a:
        r6 = new com.iqoption.d.az;
        r6.<init>(r4, r5);
        return r6;
    L_0x4380:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for base_smart_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4397:
        r6 = "layout/dialog_pending_removal_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x43a5;
    L_0x439f:
        r6 = new com.iqoption.d.je;
        r6.<init>(r4, r5);
        return r6;
    L_0x43a5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_pending_removal is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x43bc:
        r6 = "layout/micro_portfolio_open_header_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x43ca;
    L_0x43c4:
        r6 = new com.iqoption.d.aal;
        r6.<init>(r4, r5);
        return r6;
    L_0x43ca:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_open_header_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x43e1:
        r6 = "layout/closed_portfolio_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x43ef;
    L_0x43e9:
        r6 = new com.iqoption.d.fn;
        r6.<init>(r4, r5);
        return r6;
    L_0x43ef:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for closed_portfolio_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4406:
        r6 = "layout/fragment_kyc_id_declined_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4414;
    L_0x440e:
        r6 = new com.iqoption.d.nc;
        r6.<init>(r4, r5);
        return r6;
    L_0x4414:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_id_declined is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x442b:
        r6 = "layout/fragment_two_step_auth_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4439;
    L_0x4433:
        r6 = new com.iqoption.d.tg;
        r6.<init>(r4, r5);
        return r6;
    L_0x4439:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_two_step_auth is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4450:
        r6 = "layout/video_education_search_suggestion_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x445e;
    L_0x4458:
        r6 = new com.iqoption.d.alj;
        r6.<init>(r4, r5);
        return r6;
    L_0x445e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for video_education_search_suggestion_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4475:
        r6 = "layout/fragment_vip_request_call_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4483;
    L_0x447d:
        r6 = new com.iqoption.d.ua;
        r6.<init>(r4, r5);
        return r6;
    L_0x4483:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_vip_request_call is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x449a:
        r6 = "layout/micro_portfolio_mkt_on_open_single_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x44a8;
    L_0x44a2:
        r6 = new com.iqoption.d.aah;
        r6.<init>(r4, r5);
        return r6;
    L_0x44a8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_mkt_on_open_single_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x44bf:
        r6 = "layout/fragment_kyc_radio_button_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x44cd;
    L_0x44c7:
        r6 = new com.iqoption.d.nw;
        r6.<init>(r4, r5);
        return r6;
    L_0x44cd:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_radio_button is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x44e4:
        r6 = "layout/micro_smart_feed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x44f2;
    L_0x44ec:
        r6 = new com.iqoption.d.abf;
        r6.<init>(r4, r5);
        return r6;
    L_0x44f2:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_smart_feed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4509:
        r6 = "layout/chat_transfer_dialog_message_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4517;
    L_0x4511:
        r6 = new com.iqoption.d.ex;
        r6.<init>(r4, r5);
        return r6;
    L_0x4517:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_transfer_dialog_message_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x452e:
        r6 = "layout/open_binary_option_group_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x453c;
    L_0x4536:
        r6 = new com.iqoption.d.abz;
        r6.<init>(r4, r5);
        return r6;
    L_0x453c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for open_binary_option_group_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4553:
        r6 = "layout/fragment_kyc_start_non_regulated_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4561;
    L_0x455b:
        r6 = new com.iqoption.d.og;
        r6.<init>(r4, r5);
        return r6;
    L_0x4561:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_start_non_regulated is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4578:
        r6 = "layout/price_movements_filter_options_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4586;
    L_0x4580:
        r6 = new com.iqoption.d.agp;
        r6.<init>(r4, r5);
        return r6;
    L_0x4586:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for price_movements_filter_options is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x459d:
        r6 = "layout/fragment_withdrawal_crypto_3ds_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x45ab;
    L_0x45a5:
        r6 = new com.iqoption.d.ux;
        r6.<init>(r4, r5);
        return r6;
    L_0x45ab:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_withdrawal_crypto_3ds is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x45c2:
        r6 = "layout/dialog_closed_deals_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x45d0;
    L_0x45ca:
        r6 = new com.iqoption.d.ho;
        r6.<init>(r4, r5);
        return r6;
    L_0x45d0:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_closed_deals is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x45e7:
        r6 = "layout/dialog_whats_new_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x45f5;
    L_0x45ef:
        r6 = new com.iqoption.d.ka;
        r6.<init>(r4, r5);
        return r6;
    L_0x45f5:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_whats_new is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x460c:
        r6 = "layout/portfolio_exp_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x461a;
    L_0x4614:
        r6 = new com.iqoption.d.aes;
        r6.<init>(r4, r5);
        return r6;
    L_0x461a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_exp_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4631:
        r6 = "layout/close_crypto_position_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x463f;
    L_0x4639:
        r6 = new com.iqoption.d.ff;
        r6.<init>(r4, r5);
        return r6;
    L_0x463f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for close_crypto_position_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4656:
        r6 = "layout/right_panel_delegate_cfd_on_open_confirmation_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4664;
    L_0x465e:
        r6 = new com.iqoption.d.ahr;
        r6.<init>(r4, r5);
        return r6;
    L_0x4664:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_cfd_on_open_confirmation is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x467b:
        r6 = "layout/fragment_commission_change_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4689;
    L_0x4683:
        r6 = new com.iqoption.d.ln;
        r6.<init>(r4, r5);
        return r6;
    L_0x4689:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_commission_change is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x46a0:
        r6 = "layout/more_trading_opportunities_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x46ae;
    L_0x46a8:
        r6 = new com.iqoption.d.abj;
        r6.<init>(r4, r5);
        return r6;
    L_0x46ae:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for more_trading_opportunities is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x46c5:
        r6 = "layout/right_panel_delegate_crypto_main_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x46d3;
    L_0x46cd:
        r6 = new com.iqoption.d.aid;
        r6.<init>(r4, r5);
        return r6;
    L_0x46d3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_crypto_main is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x46ea:
        r6 = "layout/fragment_verify_details_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x46f8;
    L_0x46f2:
        r6 = new com.iqoption.d.tk;
        r6.<init>(r4, r5);
        return r6;
    L_0x46f8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_verify_details is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x470f:
        r6 = "layout-land/fragment_operation_history_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x471d;
    L_0x4717:
        r6 = new com.iqoption.d.pc;
        r6.<init>(r4, r5);
        return r6;
    L_0x471d:
        r6 = "layout/fragment_operation_history_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x472b;
    L_0x4725:
        r6 = new com.iqoption.d.pb;
        r6.<init>(r4, r5);
        return r6;
    L_0x472b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_operation_history is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4742:
        r6 = "layout/fragment_kyc_reportable_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4750;
    L_0x474a:
        r6 = new com.iqoption.d.ny;
        r6.<init>(r4, r5);
        return r6;
    L_0x4750:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_reportable is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4767:
        r6 = "layout/dialog_otn_commision_changed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4775;
    L_0x476f:
        r6 = new com.iqoption.d.iw;
        r6.<init>(r4, r5);
        return r6;
    L_0x4775:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_otn_commision_changed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x478c:
        r6 = "layout/dialog_overnight_fee_info_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x479a;
    L_0x4794:
        r6 = new com.iqoption.d.jc;
        r6.<init>(r4, r5);
        return r6;
    L_0x479a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for dialog_overnight_fee_info is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x47b1:
        r6 = "layout/fragment_kyc_documents_upload_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x47bf;
    L_0x47b9:
        r6 = new com.iqoption.d.mq;
        r6.<init>(r4, r5);
        return r6;
    L_0x47bf:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_documents_upload is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x47d6:
        r6 = "layout/micro_portfolio_pending_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x47e4;
    L_0x47de:
        r6 = new com.iqoption.d.aaz;
        r6.<init>(r4, r5);
        return r6;
    L_0x47e4:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for micro_portfolio_pending_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x47fb:
        r6 = "layout/cfd_confirm_dialog_view_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4809;
    L_0x4803:
        r6 = new com.iqoption.d.bv;
        r6.<init>(r4, r5);
        return r6;
    L_0x4809:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for cfd_confirm_dialog_view is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4820:
        r6 = "layout/activity_withdraw_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x482e;
    L_0x4828:
        r6 = new com.iqoption.d.ao;
        r6.<init>(r4, r5);
        return r6;
    L_0x482e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for activity_withdraw is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4845:
        r6 = "layout/close_position_delegate_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4853;
    L_0x484d:
        r6 = new com.iqoption.d.fj;
        r6.<init>(r4, r5);
        return r6;
    L_0x4853:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for close_position_delegate is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x486a:
        r6 = "layout/fragment_news_and_updates_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4878;
    L_0x4872:
        r6 = new com.iqoption.d.ow;
        r6.<init>(r4, r5);
        return r6;
    L_0x4878:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_news_and_updates is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x488f:
        r6 = "layout/portfolio_pending_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x489d;
    L_0x4897:
        r6 = new com.iqoption.d.aga;
        r6.<init>(r4, r5);
        return r6;
    L_0x489d:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_pending_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x48b4:
        r6 = "layout/string_basket_switch_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x48c2;
    L_0x48bc:
        r6 = new com.iqoption.d.akb;
        r6.<init>(r4, r5);
        return r6;
    L_0x48c2:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for string_basket_switch_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x48d9:
        r6 = "layout/fragment_withdraw_fields_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x48e7;
    L_0x48e1:
        r6 = new com.iqoption.d.un;
        r6.<init>(r4, r5);
        return r6;
    L_0x48e7:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_withdraw_fields is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x48fe:
        r6 = "layout/nps_score_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x490c;
    L_0x4906:
        r6 = new com.iqoption.d.abt;
        r6.<init>(r4, r5);
        return r6;
    L_0x490c:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for nps_score_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4923:
        r6 = "layout/chat_attachment_image_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4931;
    L_0x492b:
        r6 = new com.iqoption.d.bz;
        r6.<init>(r4, r5);
        return r6;
    L_0x4931:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_attachment_image_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4948:
        r6 = "layout/buy_new_dialog_view_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x495a;
    L_0x4950:
        r6 = new com.iqoption.d.bt;
        r0 = new android.view.View[r2];
        r0[r1] = r5;
        r6.<init>(r4, r0);
        return r6;
    L_0x495a:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for buy_new_dialog_view is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4971:
        r6 = "layout/account_security_confirm_phone_2step_auth_fragment_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x497f;
    L_0x4979:
        r6 = new com.iqoption.d.f;
        r6.<init>(r4, r5);
        return r6;
    L_0x497f:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for account_security_confirm_phone_2step_auth_fragment is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4996:
        r6 = "layout/fragment_video_education_categories_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x49a4;
    L_0x499e:
        r6 = new com.iqoption.d.to;
        r6.<init>(r4, r5);
        return r6;
    L_0x49a4:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_video_education_categories is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x49bb:
        r6 = "layout/right_panel_delegate_crypto_closed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x49c9;
    L_0x49c3:
        r6 = new com.iqoption.d.ahx;
        r6.<init>(r4, r5);
        return r6;
    L_0x49c9:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for right_panel_delegate_crypto_closed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x49e0:
        r6 = "layout/fragment_welcome_login_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x49ee;
    L_0x49e8:
        r6 = new com.iqoption.d.uc;
        r6.<init>(r4, r5);
        return r6;
    L_0x49ee:
        r6 = "layout-land/fragment_welcome_login_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x49fc;
    L_0x49f6:
        r6 = new com.iqoption.d.ud;
        r6.<init>(r4, r5);
        return r6;
    L_0x49fc:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_welcome_login is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4a13:
        r6 = "layout/fragment_kyc_question_warning_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4a21;
    L_0x4a1b:
        r6 = new com.iqoption.d.ns;
        r6.<init>(r4, r5);
        return r6;
    L_0x4a21:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_kyc_question_warning is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4a38:
        r6 = "layout/bottom_sheet_portfolio_filter_chooser_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4a46;
    L_0x4a40:
        r6 = new com.iqoption.d.bp;
        r6.<init>(r4, r5);
        return r6;
    L_0x4a46:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for bottom_sheet_portfolio_filter_chooser is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4a5d:
        r6 = "layout/chat_user_image_message_item_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4a6b;
    L_0x4a65:
        r6 = new com.iqoption.d.fb;
        r6.<init>(r4, r5);
        return r6;
    L_0x4a6b:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for chat_user_image_message_item is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4a82:
        r6 = "layout-land/portfolio_title_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4a90;
    L_0x4a8a:
        r6 = new com.iqoption.d.agf;
        r6.<init>(r4, r5);
        return r6;
    L_0x4a90:
        r6 = "layout/portfolio_title_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4a9e;
    L_0x4a98:
        r6 = new com.iqoption.d.age;
        r6.<init>(r4, r5);
        return r6;
    L_0x4a9e:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for portfolio_title is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4ab5:
        r6 = "layout/fragment_trading_history_search_details_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4ac3;
    L_0x4abd:
        r6 = new com.iqoption.d.ss;
        r6.<init>(r4, r5);
        return r6;
    L_0x4ac3:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for fragment_trading_history_search_details is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4ada:
        r6 = "layout/deposit_payment_successfully_completed_0";
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x4ae8;
    L_0x4ae2:
        r6 = new com.iqoption.d.hi;
        r6.<init>(r4, r5);
        return r6;
    L_0x4ae8:
        r4 = new java.lang.IllegalArgumentException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "The tag for deposit_payment_successfully_completed is invalid. Received: ";
        r5.append(r6);
        r5.append(r0);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x4aff:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.a.getDataBinder(android.databinding.DataBindingComponent, android.view.View, int):android.databinding.ViewDataBinding");
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0) {
            return null;
        }
        i = pc.get(i);
        if (i > 0) {
            Object tag = viewArr[0].getTag();
            StringBuilder stringBuilder;
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            } else if (i != 11) {
                if (i != 55) {
                    if (i != 177) {
                        if (i != 368) {
                            if (i != 397) {
                                if (i == 423) {
                                    if ("layout/feed_bottom_panel_0".equals(tag)) {
                                        return new ks(dataBindingComponent, viewArr);
                                    }
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("The tag for feed_bottom_panel is invalid. Received: ");
                                    stringBuilder.append(tag);
                                    throw new IllegalArgumentException(stringBuilder.toString());
                                }
                            } else if ("layout/crypto_confirm_dialog_view_0".equals(tag)) {
                                return new ft(dataBindingComponent, viewArr);
                            } else {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("The tag for crypto_confirm_dialog_view is invalid. Received: ");
                                stringBuilder.append(tag);
                                throw new IllegalArgumentException(stringBuilder.toString());
                            }
                        } else if ("layout/feed_title_0".equals(tag)) {
                            return new kw(dataBindingComponent, viewArr);
                        } else {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("The tag for feed_title is invalid. Received: ");
                            stringBuilder.append(tag);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    } else if ("layout/splash_0".equals(tag)) {
                        return new ajr(dataBindingComponent, viewArr);
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("The tag for splash is invalid. Received: ");
                        stringBuilder.append(tag);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                } else if ("layout/commission_view_0".equals(tag)) {
                    return new fp(dataBindingComponent, viewArr);
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for commission_view is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            } else if ("layout/buy_new_dialog_view_0".equals(tag)) {
                return new bt(dataBindingComponent, viewArr);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("The tag for buy_new_dialog_view is invalid. Received: ");
                stringBuilder.append(tag);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return null;
    }

    public int getLayoutId(String str) {
        String str2 = str;
        if (str2 == null) {
            return 0;
        }
        switch (str.hashCode()) {
            case -2140911412:
                if (str2.equals("layout/kyc_continue_button_0")) {
                    return R.layout.kyc_continue_button;
                }
                break;
            case -2139614800:
                if (str2.equals("layout/left_menu_item_pro_trader_0")) {
                    return R.layout.left_menu_item_pro_trader;
                }
                break;
            case -2129997939:
                if (str2.equals("layout/fragment_vip_education_0")) {
                    return R.layout.fragment_vip_education;
                }
                break;
            case -2117872007:
                if (str2.equals("layout/fragment_tutorial_0")) {
                    return R.layout.fragment_tutorial;
                }
                break;
            case -2111772050:
                if (str2.equals("layout/left_menu_item_counter_0")) {
                    return R.layout.left_menu_item_counter;
                }
                break;
            case -2109876618:
                if (str2.equals("layout/fragment_kyc_legal_name_0")) {
                    return R.layout.fragment_kyc_legal_name;
                }
                break;
            case -2106636806:
                if (str2.equals("layout-land/fragment_forgot_password_0")) {
                    return R.layout.fragment_forgot_password;
                }
                break;
            case -2101587871:
                if (str2.equals("layout/micro_portfolio_page_closed_positions_0")) {
                    return R.layout.micro_portfolio_page_closed_positions;
                }
                break;
            case -2097791717:
                if (str2.equals("layout/chat_file_message_full_item_0")) {
                    return R.layout.chat_file_message_full_item;
                }
                break;
            case -2094955360:
                if (str2.equals("layout/dialog_reload_practice_0")) {
                    return R.layout.dialog_reload_practice;
                }
                break;
            case -2092217094:
                if (str2.equals("layout/chat_room_support_toolbar_0")) {
                    return R.layout.chat_room_support_toolbar;
                }
                break;
            case -2086462860:
                if (str2.equals("layout/micro_portfolio_cfd_info_0")) {
                    return R.layout.micro_portfolio_cfd_info;
                }
                break;
            case -2082256219:
                if (str2.equals("layout/dialog_multiplier_confirm_0")) {
                    return R.layout.dialog_multiplier_confirm;
                }
                break;
            case -2080953447:
                if (str2.equals("layout/micro_portfolio_cfd_item_0")) {
                    return R.layout.micro_portfolio_cfd_item;
                }
                break;
            case -2072281889:
                if (str2.equals("layout/more_trading_opportunities_0")) {
                    return R.layout.more_trading_opportunities;
                }
                break;
            case -2072083832:
                if (str2.equals("layout/fragment_withdrawal_crypto_wallet_0")) {
                    return R.layout.fragment_withdrawal_crypto_wallet;
                }
                break;
            case -2041459450:
                if (str2.equals("layout/activity_withdraw_0")) {
                    return R.layout.activity_withdraw;
                }
                break;
            case -2020290193:
                if (str2.equals("layout/dialpad_0")) {
                    return R.layout.dialpad;
                }
                break;
            case -2015102805:
                if (str2.equals("layout/layout_welcome_social_0")) {
                    return R.layout.layout_welcome_social;
                }
                break;
            case -1989329955:
                if (str2.equals("layout/portfolio_open_header_item_0")) {
                    return R.layout.portfolio_open_header_item;
                }
                break;
            case -1988594673:
                if (str2.equals("layout/operation_history_multi_selection_0")) {
                    return R.layout.operation_history_multi_selection;
                }
                break;
            case -1987226942:
                if (str2.equals("layout/tools_content_active_tools_0")) {
                    return R.layout.tools_content_active_tools;
                }
                break;
            case -1978926873:
                if (str2.equals("layout/deposit_card_front_side_0")) {
                    return R.layout.deposit_card_front_side;
                }
                break;
            case -1976631298:
                if (str2.equals("layout/fragment_forgot_password_0")) {
                    return R.layout.fragment_forgot_password;
                }
                break;
            case -1971763605:
                if (str2.equals("layout/fragment_kyc_phone_0")) {
                    return R.layout.fragment_kyc_phone;
                }
                break;
            case -1971387630:
                if (str2.equals("layout/micro_portfolio_closed_empty_item_0")) {
                    return R.layout.micro_portfolio_closed_empty_item;
                }
                break;
            case -1968245018:
                if (str2.equals("layout/instrument_type_bottom_sheet_item_0")) {
                    return R.layout.instrument_type_bottom_sheet_item;
                }
                break;
            case -1959049376:
                if (str2.equals("layout/indicator_info_item_0")) {
                    return R.layout.indicator_info_item;
                }
                break;
            case -1958987182:
                if (str2.equals("layout/verify_card_item_0")) {
                    return R.layout.verify_card_item;
                }
                break;
            case -1942563665:
                if (str2.equals("layout/fragment_trading_history_search_details_0")) {
                    return R.layout.fragment_trading_history_search_details;
                }
                break;
            case -1932416489:
                if (str2.equals("layout/portfolio_pending_single_group_item_0")) {
                    return R.layout.portfolio_pending_single_group_item;
                }
                break;
            case -1917659229:
                if (str2.equals("layout/fragment_account_security_page_0")) {
                    return R.layout.fragment_account_security_page;
                }
                break;
            case -1891315096:
                if (str2.equals("layout/fragment_right_panel_0")) {
                    return R.layout.fragment_right_panel;
                }
                break;
            case -1879919144:
                if (str2.equals("layout/micro_article_feed_0")) {
                    return R.layout.micro_article_feed;
                }
                break;
            case -1877393184:
                if (str2.equals("layout/micro_portfolio_closed_item_0")) {
                    return R.layout.micro_portfolio_closed_item;
                }
                break;
            case -1871486702:
                if (str2.equals("layout/open_crypto_item_0")) {
                    return R.layout.open_crypto_item;
                }
                break;
            case -1871302304:
                if (str2.equals("layout/close_position_delegate_0")) {
                    return R.layout.close_position_delegate;
                }
                break;
            case -1863628763:
                if (str2.equals("layout/video_education_category_item_0")) {
                    return R.layout.video_education_category_item;
                }
                break;
            case -1836817496:
                if (str2.equals("layout/gif_whats_new_dialog_0")) {
                    return R.layout.gif_whats_new_dialog;
                }
                break;
            case -1834462211:
                if (str2.equals("layout/micro_tweet_feed_0")) {
                    return R.layout.micro_tweet_feed;
                }
                break;
            case -1832806985:
                if (str2.equals("layout/layout_protected_old_0")) {
                    return R.layout.layout_protected_old;
                }
                break;
            case -1829480918:
                if (str2.equals("layout/signal_latest_item_0")) {
                    return R.layout.signal_latest_item;
                }
                break;
            case -1827420546:
                if (str2.equals("layout-land/chat_room_support_toolbar_0")) {
                    return R.layout.chat_room_support_toolbar;
                }
                break;
            case -1824564061:
                if (str2.equals("layout/micro_portfolio_pending_group_item_0")) {
                    return R.layout.micro_portfolio_pending_group_item;
                }
                break;
            case -1806817141:
                if (str2.equals("layout/fragment_commission_change_0")) {
                    return R.layout.fragment_commission_change;
                }
                break;
            case -1785245722:
                if (str2.equals("layout/string_basket_empty_item_0")) {
                    return R.layout.string_basket_empty_item;
                }
                break;
            case -1776746651:
                if (str2.equals("layout/close_positions_item_0")) {
                    return R.layout.close_positions_item;
                }
                break;
            case -1766963152:
                if (str2.equals("layout/personal_info_dialog_0")) {
                    return R.layout.personal_info_dialog;
                }
                break;
            case -1757006399:
                if (str2.equals("layout/chat_micro_item_0")) {
                    return R.layout.chat_micro_item;
                }
                break;
            case -1751213176:
                if (str2.equals("layout/portfolio_pending_group_item_0")) {
                    return R.layout.portfolio_pending_group_item;
                }
                break;
            case -1742002951:
                if (str2.equals("layout/fragment_kyc_email_confirmed_0")) {
                    return R.layout.fragment_kyc_email_confirmed;
                }
                break;
            case -1737940668:
                if (str2.equals("layout/right_panel_delegate_crypto_closed_0")) {
                    return R.layout.right_panel_delegate_crypto_closed;
                }
                break;
            case -1735418645:
                if (str2.equals("layout/fragment_quiz_on_air_delegate_0")) {
                    return R.layout.fragment_quiz_on_air_delegate;
                }
                break;
            case -1713622621:
                if (str2.equals("layout/deposit_payment_method_item_0")) {
                    return R.layout.deposit_payment_method_item;
                }
                break;
            case -1705060944:
                if (str2.equals("layout/fragment_balance_selection_0")) {
                    return R.layout.fragment_balance_selection;
                }
                break;
            case -1649491064:
                if (str2.equals("layout/news_and_updates_item_0")) {
                    return R.layout.news_and_updates_item;
                }
                break;
            case -1638708936:
                if (str2.equals("layout/base_menu_fragment_0")) {
                    return R.layout.base_menu_fragment;
                }
                break;
            case -1635378481:
                if (str2.equals("layout/perform_verify_footer_0")) {
                    return R.layout.perform_verify_footer;
                }
                break;
            case -1633184660:
                if (str2.equals("layout/expiration_fragment_0")) {
                    return R.layout.expiration_fragment;
                }
                break;
            case -1632767615:
                if (str2.equals("layout/portfolio_mkt_on_open_single_group_item_0")) {
                    return R.layout.portfolio_mkt_on_open_single_group_item;
                }
                break;
            case -1618779995:
                if (str2.equals("layout/price_movements_high_frequency_layout_0")) {
                    return R.layout.price_movements_high_frequency_layout;
                }
                break;
            case -1610444969:
                if (str2.equals("layout/fragment_market_is_open_0")) {
                    return R.layout.fragment_market_is_open;
                }
                break;
            case -1605427838:
                if (str2.equals("layout/dialog_margin_add_on_info_0")) {
                    return R.layout.dialog_margin_add_on_info;
                }
                break;
            case -1601445214:
                if (str2.equals("layout/micro_portfolio_exp_single_group_item_0")) {
                    return R.layout.micro_portfolio_exp_single_group_item;
                }
                break;
            case -1595634083:
                if (str2.equals("layout/portfolio_exp_info_0")) {
                    return R.layout.portfolio_exp_info;
                }
                break;
            case -1590124670:
                if (str2.equals("layout/portfolio_exp_item_0")) {
                    return R.layout.portfolio_exp_item;
                }
                break;
            case -1588701809:
                if (str2.equals("layout/fragment_kyc_question_yes_no_0")) {
                    return R.layout.fragment_kyc_question_yes_no;
                }
                break;
            case -1578023804:
                if (str2.equals("layout/template_item_0")) {
                    return R.layout.template_item;
                }
                break;
            case -1571542507:
                if (str2.equals("layout/micro_portfolio_pending_empty_item_0")) {
                    return R.layout.micro_portfolio_pending_empty_item;
                }
                break;
            case -1565015601:
                if (str2.equals("layout/deposit_payment_unsuccessful_completed_0")) {
                    return R.layout.deposit_payment_unsuccessful_completed;
                }
                break;
            case -1554159233:
                if (str2.equals("layout/dialog_trade_on_practice_0")) {
                    return R.layout.dialog_trade_on_practice;
                }
                break;
            case -1541786255:
                if (str2.equals("layout/deposit_crypto_payment_method_item_0")) {
                    return R.layout.deposit_crypto_payment_method_item;
                }
                break;
            case -1538006167:
                if (str2.equals("layout/closed_portfolio_item_0")) {
                    return R.layout.closed_portfolio_item;
                }
                break;
            case -1535878558:
                if (str2.equals("layout/fragment_kyc_documents_intro_0")) {
                    return R.layout.fragment_kyc_documents_intro;
                }
                break;
            case -1530080192:
                if (str2.equals("layout/fragment_deposit_methods_old_0")) {
                    return R.layout.fragment_deposit_methods_old;
                }
                break;
            case -1529185560:
                if (str2.equals("layout/fragment_kyc_question_warning_0")) {
                    return R.layout.fragment_kyc_question_warning;
                }
                break;
            case -1498191622:
                if (str2.equals("layout/portfolio_pending_empty_item_0")) {
                    return R.layout.portfolio_pending_empty_item;
                }
                break;
            case -1496233603:
                if (str2.equals("layout/fragment_welcome_trending_0")) {
                    return R.layout.fragment_welcome_trending;
                }
                break;
            case -1488254451:
                if (str2.equals("layout/fragment_quiz_error_delegate_0")) {
                    return R.layout.fragment_quiz_error_delegate;
                }
                break;
            case -1469414522:
                if (str2.equals("layout/account_security_confirm_code_expired_fragment_0")) {
                    return R.layout.account_security_confirm_code_expired_fragment;
                }
                break;
            case -1423146301:
                if (str2.equals("layout/tools_content_settings_0")) {
                    return R.layout.tools_content_settings;
                }
                break;
            case -1419741959:
                if (str2.equals("layout/micro_portfolio_mkt_on_open_item_0")) {
                    return R.layout.micro_portfolio_mkt_on_open_item;
                }
                break;
            case -1416126874:
                if (str2.equals("layout/trailing_whats_new_dialog_0")) {
                    return R.layout.trailing_whats_new_dialog;
                }
                break;
            case -1414863686:
                if (str2.equals("layout/dialog_pro_trader_benefits_0")) {
                    return R.layout.dialog_pro_trader_benefits;
                }
                break;
            case -1397718582:
                if (str2.equals("layout/fragment_kyc_block_0")) {
                    return R.layout.fragment_kyc_block;
                }
                break;
            case -1391978147:
                if (str2.equals("layout/micro_portfolio_exp_group_item_0")) {
                    return R.layout.micro_portfolio_exp_group_item;
                }
                break;
            case -1376738758:
                if (str2.equals("layout/account_security_confirmed_phone_fragment_0")) {
                    return R.layout.account_security_confirmed_phone_fragment;
                }
                break;
            case -1375874913:
                if (str2.equals("layout/item_locale_asset_country_suggest_0")) {
                    return R.layout.item_locale_asset_country_suggest;
                }
                break;
            case -1375570365:
                if (str2.equals("layout/fragment_operation_search_result_0")) {
                    return R.layout.fragment_operation_search_result;
                }
                break;
            case -1369884071:
                if (str2.equals("layout/chat_rate_message_item_0")) {
                    return R.layout.chat_rate_message_item;
                }
                break;
            case -1362497800:
                if (str2.equals("layout/otn_leader_board_item_0")) {
                    return R.layout.otn_leader_board_item;
                }
                break;
            case -1336577216:
                if (str2.equals("layout/dialog_portfolio_invest_info_0")) {
                    return R.layout.dialog_portfolio_invest_info;
                }
                break;
            case -1329423942:
                if (str2.equals("layout/price_movements_item_0")) {
                    return R.layout.price_movements_item;
                }
                break;
            case -1322775430:
                if (str2.equals("layout/high_frequency_panel_item_0")) {
                    return R.layout.high_frequency_panel_item;
                }
                break;
            case -1319585403:
                if (str2.equals("layout/chat_image_message_head_item_0")) {
                    return R.layout.chat_image_message_head_item;
                }
                break;
            case -1309611442:
                if (str2.equals("layout/deposit_old_amount_line_0")) {
                    return R.layout.deposit_old_amount_line;
                }
                break;
            case -1301536667:
                if (str2.equals("layout/dialog_otn_expectation_0")) {
                    return R.layout.dialog_otn_expectation;
                }
                break;
            case -1286554444:
                if (str2.equals("layout/string_basket_item_0")) {
                    return R.layout.string_basket_item;
                }
                break;
            case -1280631380:
                if (str2.equals("layout/fragment_kyc_phone_confirm_0")) {
                    return R.layout.fragment_kyc_phone_confirm;
                }
                break;
            case -1280500585:
                if (str2.equals("layout/fragment_verify_details_0")) {
                    return R.layout.fragment_verify_details;
                }
                break;
            case -1255293663:
                if (str2.equals("layout/chat_transfer_dialog_message_item_0")) {
                    return R.layout.chat_transfer_dialog_message_item;
                }
                break;
            case -1251920286:
                if (str2.equals("layout/withdraw_history_payout_item_0")) {
                    return R.layout.withdraw_history_payout_item;
                }
                break;
            case -1242790057:
                if (str2.equals("layout/fragment_otn_leading_board_user_board_trading_0")) {
                    return R.layout.fragment_otn_leading_board_user_board_trading;
                }
                break;
            case -1240546211:
                if (str2.equals("layout/right_panel_delegate_digital_call_put_0")) {
                    return R.layout.right_panel_delegate_digital_call_put;
                }
                break;
            case -1232940240:
                if (str2.equals("layout/chat_room_send_layout_0")) {
                    return R.layout.chat_room_send_layout;
                }
                break;
            case -1229674196:
                if (str2.equals("layout/account_security_confirm_code_fragment_0")) {
                    return R.layout.account_security_confirm_code_fragment;
                }
                break;
            case -1225136392:
                if (str2.equals("layout/vip_about_info_0")) {
                    return R.layout.vip_about_info;
                }
                break;
            case -1215044296:
                if (str2.equals("layout/micro_portfolio_exp_info_0")) {
                    return R.layout.micro_portfolio_exp_info;
                }
                break;
            case -1214737383:
                if (str2.equals("layout/fragment_quiz_promocode_delegate_0")) {
                    return R.layout.fragment_quiz_promocode_delegate;
                }
                break;
            case -1211826810:
                if (str2.equals("layout/withdraw_history_title_item_0")) {
                    return R.layout.withdraw_history_title_item;
                }
                break;
            case -1209534883:
                if (str2.equals("layout/micro_portfolio_exp_item_0")) {
                    return R.layout.micro_portfolio_exp_item;
                }
                break;
            case -1191453693:
                if (str2.equals("layout/dialog_pending_removal_0")) {
                    return R.layout.dialog_pending_removal;
                }
                break;
            case -1190756847:
                if (str2.equals("layout/whats_new_video_dialog_0")) {
                    return R.layout.whats_new_video_dialog;
                }
                break;
            case -1184953241:
                if (str2.equals("layout/dialog_closed_deals_item_cfd_aggregated_0")) {
                    return R.layout.dialog_closed_deals_item_cfd_aggregated;
                }
                break;
            case -1174061270:
                if (str2.equals("layout/tools_fragment_0")) {
                    return R.layout.tools_fragment;
                }
                break;
            case -1159581395:
                if (str2.equals("layout/feed_title_0")) {
                    return R.layout.feed_title;
                }
                break;
            case -1155960629:
                if (str2.equals("layout/bottom_sheet_portfolio_filter_chooser_0")) {
                    return R.layout.bottom_sheet_portfolio_filter_chooser;
                }
                break;
            case -1151758259:
                if (str2.equals("layout/string_basket_remove_all_item_0")) {
                    return R.layout.string_basket_remove_all_item;
                }
                break;
            case -1139264235:
                if (str2.equals("layout/chat_image_message_tail_item_0")) {
                    return R.layout.chat_image_message_tail_item;
                }
                break;
            case -1124181279:
                if (str2.equals("layout/session_other_item_0")) {
                    return R.layout.session_other_item;
                }
                break;
            case -1121839950:
                if (str2.equals("layout/portfolio_pending_header_item_0")) {
                    return R.layout.portfolio_pending_header_item;
                }
                break;
            case -1120271343:
                if (str2.equals("layout/right_panel_delegate_crypto_main_0")) {
                    return R.layout.right_panel_delegate_crypto_main;
                }
                break;
            case -1083122353:
                if (str2.equals("layout-land/fragment_welcome_login_0")) {
                    return R.layout.fragment_welcome_login;
                }
                break;
            case -1073472730:
                if (str2.equals("layout/chat_dialog_cant_send_reason_0")) {
                    return R.layout.chat_dialog_cant_send_reason;
                }
                break;
            case -1039513009:
                if (str2.equals("layout/dialog_closed_deals_item_do_0")) {
                    return R.layout.dialog_closed_deals_item_do;
                }
                break;
            case -1037610000:
                if (str2.equals("layout/dialog_otn_commision_changed_0")) {
                    return R.layout.dialog_otn_commision_changed;
                }
                break;
            case -1035900494:
                if (str2.equals("layout-land/withdraw_field_constructor_0")) {
                    return R.layout.withdraw_field_constructor;
                }
                break;
            case -1034272893:
                if (str2.equals("layout/deposit_payment_successfully_completed_0")) {
                    return R.layout.deposit_payment_successfully_completed;
                }
                break;
            case -1029431671:
                if (str2.equals("layout/video_education_tag_item_0")) {
                    return R.layout.video_education_tag_item;
                }
                break;
            case -1001508417:
                if (str2.equals("layout/right_panel_delegate_cfd_main_0")) {
                    return R.layout.right_panel_delegate_cfd_main;
                }
                break;
            case -1000702836:
                if (str2.equals("layout/local_toast_layout_0")) {
                    return R.layout.local_toast_layout;
                }
                break;
            case -998168615:
                if (str2.equals("layout/chat_text_message_body_item_0")) {
                    return R.layout.chat_text_message_body_item;
                }
                break;
            case -978689889:
                if (str2.equals("layout/verify_side_hint_0")) {
                    return R.layout.verify_side_hint;
                }
                break;
            case -967759035:
                if (str2.equals("layout/commission_view_0")) {
                    return R.layout.commission_view;
                }
                break;
            case -951481415:
                if (str2.equals("layout/signal_loading_item_0")) {
                    return R.layout.signal_loading_item;
                }
                break;
            case -949081631:
                if (str2.equals("layout/portfolio_cfd_single_group_item_0")) {
                    return R.layout.portfolio_cfd_single_group_item;
                }
                break;
            case -944499983:
                if (str2.equals("layout/activity_pro_trader_web_0")) {
                    return R.layout.activity_pro_trader_web;
                }
                break;
            case -944472798:
                if (str2.equals("layout-sw720dp/bg_chooser_dialog_0")) {
                    return R.layout.bg_chooser_dialog;
                }
                break;
            case -940176853:
                if (str2.equals("layout/verify_side_item_0")) {
                    return R.layout.verify_side_item;
                }
                break;
            case -918847726:
                if (str2.equals("layout/fragment_promo_video_0")) {
                    return R.layout.fragment_promo_video;
                }
                break;
            case -918394320:
                if (str2.equals("layout/fx_whats_new_dialog_0")) {
                    return R.layout.fx_whats_new_dialog;
                }
                break;
            case -916100268:
                if (str2.equals("layout-land/chat_room_public_toolbar_0")) {
                    return R.layout.chat_room_public_toolbar;
                }
                break;
            case -908370771:
                if (str2.equals("layout/right_panel_delegate_crypto_success_0")) {
                    return R.layout.right_panel_delegate_crypto_success;
                }
                break;
            case -902929238:
                if (str2.equals("layout/chat_file_message_head_item_0")) {
                    return R.layout.chat_file_message_head_item;
                }
                break;
            case -898545975:
                if (str2.equals("layout/fx_strike_item_0")) {
                    return R.layout.fx_strike_item;
                }
                break;
            case -897253970:
                if (str2.equals("layout/deposit_page_old_0")) {
                    return R.layout.deposit_page_old;
                }
                break;
            case -889087510:
                if (str2.equals("layout/right_panel_delegate_turbo_binary_0")) {
                    return R.layout.right_panel_delegate_turbo_binary;
                }
                break;
            case -888398627:
                if (str2.equals("layout/fragment_trial_registration_0")) {
                    return R.layout.fragment_trial_registration;
                }
                break;
            case -880082881:
                if (str2.equals("layout-land/fragment_operation_search_result_0")) {
                    return R.layout.fragment_operation_search_result;
                }
                break;
            case -866104518:
                if (str2.equals("layout/fragment_otn_leading_board_user_board_date_0")) {
                    return R.layout.fragment_otn_leading_board_user_board_date;
                }
                break;
            case -852889424:
                if (str2.equals("layout/fragment_quiz_0")) {
                    return R.layout.fragment_quiz;
                }
                break;
            case -836987947:
                if (str2.equals("layout/chat_fragment_file_picker_0")) {
                    return R.layout.chat_fragment_file_picker;
                }
                break;
            case -829635146:
                if (str2.equals("layout/fragment_room_0")) {
                    return R.layout.fragment_room;
                }
                break;
            case -819866179:
                if (str2.equals("layout/bottom_sheet_chooser_0")) {
                    return R.layout.bottom_sheet_chooser;
                }
                break;
            case -813591322:
                if (str2.equals("layout/chat_file_picker_empty_item_0")) {
                    return R.layout.chat_file_picker_empty_item;
                }
                break;
            case -805392539:
                if (str2.equals("layout/deposit_payment_authorization_page_0")) {
                    return R.layout.deposit_payment_authorization_page;
                }
                break;
            case -796169236:
                if (str2.equals("layout/ichimoku_dialog_0")) {
                    return R.layout.ichimoku_dialog;
                }
                break;
            case -790612385:
                if (str2.equals("layout/dialog_gdpr_warning_0")) {
                    return R.layout.dialog_gdpr_warning;
                }
                break;
            case -786157184:
                if (str2.equals("layout/open_binary_option_item_0")) {
                    return R.layout.open_binary_option_item;
                }
                break;
            case -786094760:
                if (str2.equals("layout/chat_room_public_toolbar_0")) {
                    return R.layout.chat_room_public_toolbar;
                }
                break;
            case -782717151:
                if (str2.equals("layout/nps_score_fragment_0")) {
                    return R.layout.nps_score_fragment;
                }
                break;
            case -767590325:
                if (str2.equals("layout/account_security_email_confirm_fragment_0")) {
                    return R.layout.account_security_email_confirm_fragment;
                }
                break;
            case -766235642:
                if (str2.equals("layout/macro_feed_options_0")) {
                    return R.layout.macro_feed_options;
                }
                break;
            case -753014705:
                if (str2.equals("layout-sw600dp/deposit_page_content_0")) {
                    return R.layout.deposit_page_content;
                }
                break;
            case -743842215:
                if (str2.equals("layout/dialpad_key_back_0")) {
                    return R.layout.dialpad_key_back;
                }
                break;
            case -728588219:
                if (str2.equals("layout/dialog_overnight_fee_info_0")) {
                    return R.layout.dialog_overnight_fee_info;
                }
                break;
            case -728512114:
                if (str2.equals("layout/fragment_micro_room_list_0")) {
                    return R.layout.fragment_micro_room_list;
                }
                break;
            case -728360818:
                if (str2.equals("layout/micro_portfolio_total_pager_page_0")) {
                    return R.layout.micro_portfolio_total_pager_page;
                }
                break;
            case -726591772:
                if (str2.equals("layout/tools_content_indicators_0")) {
                    return R.layout.tools_content_indicators;
                }
                break;
            case -722608070:
                if (str2.equals("layout/chat_file_message_tail_item_0")) {
                    return R.layout.chat_file_message_tail_item;
                }
                break;
            case -711702152:
                if (str2.equals("layout/fragment_quiz_leaderboard_delegate_0")) {
                    return R.layout.fragment_quiz_leaderboard_delegate;
                }
                break;
            case -686962814:
                if (str2.equals("layout/fragment_quiz_question_language_0")) {
                    return R.layout.fragment_quiz_question_language;
                }
                break;
            case -684791592:
                if (str2.equals("layout/fragment_withdraw_methods_0")) {
                    return R.layout.fragment_withdraw_methods;
                }
                break;
            case -656655160:
                if (str2.equals("layout/nps_feedback_fragment_0")) {
                    return R.layout.nps_feedback_fragment;
                }
                break;
            case -654658890:
                if (str2.equals("layout/withdraw_field_constructor_0")) {
                    return R.layout.withdraw_field_constructor;
                }
                break;
            case -653827774:
                if (str2.equals("layout/deposit_page_content_no_bonus_0")) {
                    return R.layout.deposit_page_content_no_bonus;
                }
                break;
            case -649892400:
                if (str2.equals("layout/fragment_pro_trader_web_0")) {
                    return R.layout.fragment_pro_trader_web;
                }
                break;
            case -642531554:
                if (str2.equals("layout/fragment_margin_not_added_0")) {
                    return R.layout.fragment_margin_not_added;
                }
                break;
            case -631840537:
                if (str2.equals("layout/fragment_left_panel_0")) {
                    return R.layout.fragment_left_panel;
                }
                break;
            case -622008619:
                if (str2.equals("layout/fragment_withdrawal_crypto_3ds_0")) {
                    return R.layout.fragment_withdrawal_crypto_3ds;
                }
                break;
            case -620163739:
                if (str2.equals("layout/right_panel_delegate_turbo_binary_call_put_0")) {
                    return R.layout.right_panel_delegate_turbo_binary_call_put;
                }
                break;
            case -618392834:
                if (str2.equals("layout/price_movements_filter_options_0")) {
                    return R.layout.price_movements_filter_options;
                }
                break;
            case -613194629:
                if (str2.equals("layout/fragment_withdraw_verify_page_0")) {
                    return R.layout.fragment_withdraw_verify_page;
                }
                break;
            case -608075893:
                if (str2.equals("layout/fragment_vip_request_call_0")) {
                    return R.layout.fragment_vip_request_call;
                }
                break;
            case -603418283:
                if (str2.equals("layout/fragment_withdraw_verify_0")) {
                    return R.layout.fragment_withdraw_verify;
                }
                break;
            case -596180602:
                if (str2.equals("layout/micro_portfolio_mkt_on_open_single_group_item_0")) {
                    return R.layout.micro_portfolio_mkt_on_open_single_group_item;
                }
                break;
            case -594312788:
                if (str2.equals("layout/fragment_quiz_update_delegate_0")) {
                    return R.layout.fragment_quiz_update_delegate;
                }
                break;
            case -587422661:
                if (str2.equals("layout/right_panel_delegate_cfd_confirmation_0")) {
                    return R.layout.right_panel_delegate_cfd_confirmation;
                }
                break;
            case -585672454:
                if (str2.equals("layout/micro_portfolio_page_pending_positions_0")) {
                    return R.layout.micro_portfolio_page_pending_positions;
                }
                break;
            case -569681208:
                if (str2.equals("layout/fragment_withdrawal_crypto_kyc_0")) {
                    return R.layout.fragment_withdrawal_crypto_kyc;
                }
                break;
            case -566457365:
                if (str2.equals("layout/vip_education_session_item_0")) {
                    return R.layout.vip_education_session_item;
                }
                break;
            case -552762327:
                if (str2.equals("layout/feed_web_0")) {
                    return R.layout.feed_web;
                }
                break;
            case -549082525:
                if (str2.equals("layout/fragment_kyc_sex_0")) {
                    return R.layout.fragment_kyc_sex;
                }
                break;
            case -548976582:
                if (str2.equals("layout/portfolio_page_open_positions_0")) {
                    return R.layout.portfolio_page_open_positions;
                }
                break;
            case -543394369:
                if (str2.equals("layout-land/fragment_operation_history_0")) {
                    return R.layout.fragment_operation_history;
                }
                break;
            case -539219682:
                if (str2.equals("layout/portfolio_mkt_on_open_item_0")) {
                    return R.layout.portfolio_mkt_on_open_item;
                }
                break;
            case -539143851:
                if (str2.equals("layout/dialog_closed_deals_header_do_0")) {
                    return R.layout.dialog_closed_deals_header_do;
                }
                break;
            case -537265140:
                if (str2.equals("layout/kdj_dialog_0")) {
                    return R.layout.kdj_dialog;
                }
                break;
            case -531028989:
                if (str2.equals("layout/deposit_card_processing_page_0")) {
                    return R.layout.deposit_card_processing_page;
                }
                break;
            case -530577355:
                if (str2.equals("layout/fragment_kyc_document_address_0")) {
                    return R.layout.fragment_kyc_document_address;
                }
                break;
            case -507413984:
                if (str2.equals("layout/withdraw_limit_reason_dialog_0")) {
                    return R.layout.withdraw_limit_reason_dialog;
                }
                break;
            case -485275794:
                if (str2.equals("layout/fragment_video_education_videos_0")) {
                    return R.layout.fragment_video_education_videos;
                }
                break;
            case -455896154:
                if (str2.equals("layout/right_panel_delegate_crypto_loading_0")) {
                    return R.layout.right_panel_delegate_crypto_loading;
                }
                break;
            case -451247875:
                if (str2.equals("layout/feed_bottom_panel_0")) {
                    return R.layout.feed_bottom_panel;
                }
                break;
            case -444879886:
                if (str2.equals("layout/right_panel_delegate_digital_0")) {
                    return R.layout.right_panel_delegate_digital;
                }
                break;
            case -433411385:
                if (str2.equals("layout/fragment_otn_leading_board_user_board_seen_0")) {
                    return R.layout.fragment_otn_leading_board_user_board_seen;
                }
                break;
            case -420658865:
                if (str2.equals("layout/left_menu_item_snippet_0")) {
                    return R.layout.left_menu_item_snippet;
                }
                break;
            case -418714670:
                if (str2.equals("layout/open_cfd_item_0")) {
                    return R.layout.open_cfd_item;
                }
                break;
            case -414589990:
                if (str2.equals("layout/item_payment_method_old_0")) {
                    return R.layout.item_payment_method_old;
                }
                break;
            case -414152734:
                if (str2.equals("layout/chat_attachment_image_item_0")) {
                    return R.layout.chat_attachment_image_item;
                }
                break;
            case -413432655:
                if (str2.equals("layout/fragment_mkt_on_open_created_0")) {
                    return R.layout.fragment_mkt_on_open_created;
                }
                break;
            case -412754722:
                if (str2.equals("layout/dialog_commision_info_0")) {
                    return R.layout.dialog_commision_info;
                }
                break;
            case -400040418:
                if (str2.equals("layout/sell_delegate_0")) {
                    return R.layout.sell_delegate;
                }
                break;
            case -389812234:
                if (str2.equals("layout/chat_fragment_search_room_0")) {
                    return R.layout.chat_fragment_search_room;
                }
                break;
            case -388679624:
                if (str2.equals("layout/fragment_kyc_finish_0")) {
                    return R.layout.fragment_kyc_finish;
                }
                break;
            case -366349138:
                if (str2.equals("layout/left_menu_item_list_0")) {
                    return R.layout.left_menu_item_list;
                }
                break;
            case -363219945:
                if (str2.equals("layout/fragment_otn_leading_board_user_board_user_0")) {
                    return R.layout.fragment_otn_leading_board_user_board_user;
                }
                break;
            case -360230978:
                if (str2.equals("layout/chat_dialog_user_info_0")) {
                    return R.layout.chat_dialog_user_info;
                }
                break;
            case -351493731:
                if (str2.equals("layout/macro_smart_feed_0")) {
                    return R.layout.macro_smart_feed;
                }
                break;
            case -322785628:
                if (str2.equals("layout/left_menu_item_drop_down_0")) {
                    return R.layout.left_menu_item_drop_down;
                }
                break;
            case -318227575:
                if (str2.equals("layout/confirm_dialog_view_0")) {
                    return R.layout.confirm_dialog_view;
                }
                break;
            case -302959643:
                if (str2.equals("layout/selling_price_layout_0")) {
                    return R.layout.selling_price_layout;
                }
                break;
            case -301322532:
                if (str2.equals("layout/deposit_page_crypto_0")) {
                    return R.layout.deposit_page_crypto;
                }
                break;
            case -290592404:
                if (str2.equals("layout/operation_search_result_item_0")) {
                    return R.layout.operation_search_result_item;
                }
                break;
            case -280919718:
                if (str2.equals("layout/item_welcome_trending_0")) {
                    return R.layout.item_welcome_trending;
                }
                break;
            case -279734374:
                if (str2.equals("layout/fragment_vip_choose_time_0")) {
                    return R.layout.fragment_vip_choose_time;
                }
                break;
            case -275945582:
                if (str2.equals("layout/fragment_signals_0")) {
                    return R.layout.fragment_signals;
                }
                break;
            case -260316398:
                if (str2.equals("layout/activity_pro_deposit_0")) {
                    return R.layout.activity_pro_deposit;
                }
                break;
            case -254853830:
                if (str2.equals("layout/close_crypto_position_delegate_0")) {
                    return R.layout.close_crypto_position_delegate;
                }
                break;
            case -249525428:
                if (str2.equals("layout/account_security_confirmed_email_fragment_0")) {
                    return R.layout.account_security_confirmed_email_fragment;
                }
                break;
            case -235433208:
                if (str2.equals("layout/micro_feed_title_0")) {
                    return R.layout.micro_feed_title;
                }
                break;
            case -223161297:
                if (str2.equals("layout/fragment_quiz_insights_title_item_0")) {
                    return R.layout.fragment_quiz_insights_title_item;
                }
                break;
            case -216132163:
                if (str2.equals("layout/dialog_margin_add_on_position_0")) {
                    return R.layout.dialog_margin_add_on_position;
                }
                break;
            case -212793164:
                if (str2.equals("layout-xlarge-xhdpi/fragment_balance_selection_0")) {
                    return R.layout.fragment_balance_selection;
                }
                break;
            case -207760284:
                if (str2.equals("layout/vip_education_item_view_0")) {
                    return R.layout.vip_education_item_view;
                }
                break;
            case -197777934:
                if (str2.equals("layout/chat_user_image_message_item_0")) {
                    return R.layout.chat_user_image_message_item;
                }
                break;
            case -190661000:
                if (str2.equals("layout/fragment_dark_dialog_0")) {
                    return R.layout.fragment_dark_dialog;
                }
                break;
            case -188382052:
                if (str2.equals("layout/micro_portfolio_pending_single_group_item_0")) {
                    return R.layout.micro_portfolio_pending_single_group_item;
                }
                break;
            case -186380988:
                if (str2.equals("layout/fragment_kyc_gdpr_0")) {
                    return R.layout.fragment_kyc_gdpr;
                }
                break;
            case -183690876:
                if (str2.equals("layout/fragment_kyc_question_single_choice_0")) {
                    return R.layout.fragment_kyc_question_single_choice;
                }
                break;
            case -174463269:
                if (str2.equals("layout/left_menu_item_profile_0")) {
                    return R.layout.left_menu_item_profile;
                }
                break;
            case -173146223:
                if (str2.equals("layout/fragment_kyc_check_box_0")) {
                    return R.layout.fragment_kyc_check_box;
                }
                break;
            case -167301748:
                if (str2.equals("layout/fragment_pro_trader_active_0")) {
                    return R.layout.fragment_pro_trader_active;
                }
                break;
            case -164508927:
                if (str2.equals("layout/fragment_kyc_risks_0")) {
                    return R.layout.fragment_kyc_risks;
                }
                break;
            case -162152765:
                if (str2.equals("layout/fragment_operation_history_0")) {
                    return R.layout.fragment_operation_history;
                }
                break;
            case -160153844:
                if (str2.equals("layout/fragment_kyc_question_warning2_0")) {
                    return R.layout.fragment_kyc_question_warning2;
                }
                break;
            case -154152040:
                if (str2.equals("layout/fragment_multiplier_chooser_0")) {
                    return R.layout.fragment_multiplier_chooser;
                }
                break;
            case -141024137:
                if (str2.equals("layout/open_digital_option_group_item_0")) {
                    return R.layout.open_digital_option_group_item;
                }
                break;
            case -135991374:
                if (str2.equals("layout/price_movements_filter_fragment_0")) {
                    return R.layout.price_movements_filter_fragment;
                }
                break;
            case -134289960:
                if (str2.equals("layout/fragment_kyc_cysec_0")) {
                    return R.layout.fragment_kyc_cysec;
                }
                break;
            case -115983875:
                if (str2.equals("layout/overnight_fee_item_0")) {
                    return R.layout.overnight_fee_item;
                }
                break;
            case -111823201:
                if (str2.equals("layout/deposit_card_view_0")) {
                    return R.layout.deposit_card_view;
                }
                break;
            case -105215538:
                if (str2.equals("layout/chat_fragment_attachment_picker_0")) {
                    return R.layout.chat_fragment_attachment_picker;
                }
                break;
            case -103407717:
                if (str2.equals("layout/fragment_quiz_error_item_0")) {
                    return R.layout.fragment_quiz_error_item;
                }
                break;
            case -103266611:
                if (str2.equals("layout/chat_user_file_message_item_0")) {
                    return R.layout.chat_user_file_message_item;
                }
                break;
            case -91867064:
                if (str2.equals("layout/nps_completed_fragment_0")) {
                    return R.layout.nps_completed_fragment;
                }
                break;
            case -80835541:
                if (str2.equals("layout-land/active_sessions_fragment_0")) {
                    return R.layout.active_sessions_fragment;
                }
                break;
            case -72980645:
                if (str2.equals("layout/fragment_account_security_passcode_error_0")) {
                    return R.layout.fragment_account_security_passcode_error;
                }
                break;
            case -71105352:
                if (str2.equals("layout/portfolio_exp_header_item_0")) {
                    return R.layout.portfolio_exp_header_item;
                }
                break;
            case -69557139:
                if (str2.equals("layout/portfolio_title_0")) {
                    return R.layout.portfolio_title;
                }
                break;
            case -57960789:
                if (str2.equals("layout/macro_video_feed_0")) {
                    return R.layout.macro_video_feed;
                }
                break;
            case -54750526:
                if (str2.equals("layout/portfolio_exp_group_item_0")) {
                    return R.layout.portfolio_exp_group_item;
                }
                break;
            case -52597798:
                if (str2.equals("layout/dialpad_key_zero_0")) {
                    return R.layout.dialpad_key_zero;
                }
                break;
            case -41991494:
                if (str2.equals("layout/dialog_confirm_close_pending_position_0")) {
                    return R.layout.dialog_confirm_close_pending_position;
                }
                break;
            case -23567598:
                if (str2.equals("layout/open_cfd_group_item_0")) {
                    return R.layout.open_cfd_group_item;
                }
                break;
            case -15731608:
                if (str2.equals("layout/bottom_sheet_portfolio_tpsl_chooser_0")) {
                    return R.layout.bottom_sheet_portfolio_tpsl_chooser;
                }
                break;
            case -6943002:
                if (str2.equals("layout/micro_portfolio_cfd_single_group_item_0")) {
                    return R.layout.micro_portfolio_cfd_single_group_item;
                }
                break;
            case -2689587:
                if (str2.equals("layout/whats_new_dialog_0")) {
                    return R.layout.whats_new_dialog;
                }
                break;
            case 14608113:
                if (str2.equals("layout/account_security_turn_on_2step_auth_fragment_0")) {
                    return R.layout.account_security_turn_on_2step_auth_fragment;
                }
                break;
            case 18935683:
                if (str2.equals("layout/chat_image_message_body_item_0")) {
                    return R.layout.chat_image_message_body_item;
                }
                break;
            case 26693243:
                if (str2.equals("layout/session_title_0")) {
                    return R.layout.session_title;
                }
                break;
            case 34374099:
                if (str2.equals("layout/fragment_traderoom_restriction_0")) {
                    return R.layout.fragment_traderoom_restriction;
                }
                break;
            case 34697625:
                if (str2.equals("layout/micro_portfolio_cfd_group_item_0")) {
                    return R.layout.micro_portfolio_cfd_group_item;
                }
                break;
            case 38738449:
                if (str2.equals("layout/fragment_news_and_updates_0")) {
                    return R.layout.fragment_news_and_updates;
                }
                break;
            case 41524817:
                if (str2.equals("layout/dialog_congrat_otn_emission_executed_0")) {
                    return R.layout.dialog_congrat_otn_emission_executed;
                }
                break;
            case 49169967:
                if (str2.equals("layout/active_sessions_fragment_0")) {
                    return R.layout.active_sessions_fragment;
                }
                break;
            case 63725164:
                if (str2.equals("layout/deposit_currency_item_0")) {
                    return R.layout.deposit_currency_item;
                }
                break;
            case 67212001:
                if (str2.equals("layout/left_menu_item_button_grayed_0")) {
                    return R.layout.left_menu_item_button_grayed;
                }
                break;
            case 92752593:
                if (str2.equals("layout/fragment_trading_history_set_asset_0")) {
                    return R.layout.fragment_trading_history_set_asset;
                }
                break;
            case 96263415:
                if (str2.equals("layout/open_digital_option_item_0")) {
                    return R.layout.open_digital_option_item;
                }
                break;
            case 98588583:
                if (str2.equals("layout/smart_feed_fragment_0")) {
                    return R.layout.smart_feed_fragment;
                }
                break;
            case 119807936:
                if (str2.equals("layout/fragment_kyc_acceptable_documents_0")) {
                    return R.layout.fragment_kyc_acceptable_documents;
                }
                break;
            case 127098195:
                if (str2.equals("layout/price_movements_filter_menu_item_0")) {
                    return R.layout.price_movements_filter_menu_item;
                }
                break;
            case 131694918:
                if (str2.equals("layout/popup_window_currency_selection_0")) {
                    return R.layout.popup_window_currency_selection;
                }
                break;
            case 136392815:
                if (str2.equals("layout/portfolio_open_empty_item_0")) {
                    return R.layout.portfolio_open_empty_item;
                }
                break;
            case 143255347:
                if (str2.equals("layout/fragment_welcome_onboarding_0")) {
                    return R.layout.fragment_welcome_onboarding;
                }
                break;
            case 143693652:
                if (str2.equals("layout/activity_chat_0")) {
                    return R.layout.activity_chat;
                }
                break;
            case 161579406:
                if (str2.equals("layout/cfd_expiration_fragment_0")) {
                    return R.layout.cfd_expiration_fragment;
                }
                break;
            case 176620090:
                if (str2.equals("layout/dialog_closed_deals_header_list_binary_0")) {
                    return R.layout.dialog_closed_deals_header_list_binary;
                }
                break;
            case 177264990:
                if (str2.equals("layout-land/fragment_operation_history_options_0")) {
                    return R.layout.fragment_operation_history_options;
                }
                break;
            case 178605179:
                if (str2.equals("layout/right_panel_delegate_cfd_0")) {
                    return R.layout.right_panel_delegate_cfd;
                }
                break;
            case 223962101:
                if (str2.equals("layout/macro_tweet_feed_0")) {
                    return R.layout.macro_tweet_feed;
                }
                break;
            case 227022815:
                if (str2.equals("layout/portfolio_delegate_macro_0")) {
                    return R.layout.portfolio_delegate_macro;
                }
                break;
            case 228417966:
                if (str2.equals("layout/chat_room_private_toolbar_0")) {
                    return R.layout.chat_room_private_toolbar;
                }
                break;
            case 237905212:
                if (str2.equals("layout/fragment_video_education_searched_videos_0")) {
                    return R.layout.fragment_video_education_searched_videos;
                }
                break;
            case 259547186:
                if (str2.equals("layout/fragment_vip_about_0")) {
                    return R.layout.fragment_vip_about;
                }
                break;
            case 270562033:
                if (str2.equals("layout-land/portfolio_title_0")) {
                    return R.layout.portfolio_title;
                }
                break;
            case 272530649:
                if (str2.equals("layout/dialog_pro_trader_selected_0")) {
                    return R.layout.dialog_pro_trader_selected;
                }
                break;
            case 272801119:
                if (str2.equals("layout/portfolio_page_pending_positions_0")) {
                    return R.layout.portfolio_page_pending_positions;
                }
                break;
            case 285723986:
                if (str2.equals("layout/fragment_account_security_passcode_0")) {
                    return R.layout.fragment_account_security_passcode;
                }
                break;
            case 305037020:
                if (str2.equals("layout/template_instrument_item_0")) {
                    return R.layout.template_instrument_item;
                }
                break;
            case 312839581:
                if (str2.equals("layout/splash_0")) {
                    return R.layout.splash;
                }
                break;
            case 314789747:
                if (str2.equals("layout/fragment_kyc_reportable_0")) {
                    return R.layout.fragment_kyc_reportable;
                }
                break;
            case 353933055:
                if (str2.equals("layout/price_movements_tittle_item_0")) {
                    return R.layout.price_movements_tittle_item;
                }
                break;
            case 365779319:
                if (str2.equals("layout/personal_info_page_0")) {
                    return R.layout.personal_info_page;
                }
                break;
            case 373215491:
                if (str2.equals("layout/numpad_0")) {
                    return R.layout.numpad;
                }
                break;
            case 375858912:
                if (str2.equals("layout/rate_us_dialog_0")) {
                    return R.layout.rate_us_dialog;
                }
                break;
            case 376586986:
                if (str2.equals("layout/otn_history_item_0")) {
                    return R.layout.otn_history_item;
                }
                break;
            case 379928579:
                if (str2.equals("layout/portfolio_balance_cash_0")) {
                    return R.layout.portfolio_balance_cash;
                }
                break;
            case 398992419:
                if (str2.equals("layout/fragment_pending_order_executed_0")) {
                    return R.layout.fragment_pending_order_executed;
                }
                break;
            case 401073913:
                if (str2.equals("layout/account_security_confirm_phone_fragment_0")) {
                    return R.layout.account_security_confirm_phone_fragment;
                }
                break;
            case 401939035:
                if (str2.equals("layout/fragment_quiz_off_air_delegate_0")) {
                    return R.layout.fragment_quiz_off_air_delegate;
                }
                break;
            case 403126284:
                if (str2.equals("layout-land/fragment_withdrawal_crypto_wallet_0")) {
                    return R.layout.fragment_withdrawal_crypto_wallet;
                }
                break;
            case 406508454:
                if (str2.equals("layout/fragment_quiz_leaderboard_you_item_0")) {
                    return R.layout.fragment_quiz_leaderboard_you_item;
                }
                break;
            case 407686906:
                if (str2.equals("layout/chat_fragment_image_preview_slider_0")) {
                    return R.layout.chat_fragment_image_preview_slider;
                }
                break;
            case 419746933:
                if (str2.equals("layout/crypto_confirm_dialog_view_0")) {
                    return R.layout.crypto_confirm_dialog_view;
                }
                break;
            case 427154261:
                if (str2.equals("layout/fragment_withdraw_complete_0")) {
                    return R.layout.fragment_withdraw_complete;
                }
                break;
            case 432518270:
                if (str2.equals("layout/price_movements_high_frequecy_item_0")) {
                    return R.layout.price_movements_high_frequecy_item;
                }
                break;
            case 435591848:
                if (str2.equals("layout/chat_file_message_body_item_0")) {
                    return R.layout.chat_file_message_body_item;
                }
                break;
            case 438676548:
                if (str2.equals("layout/dialog_closed_deals_header_list_do_0")) {
                    return R.layout.dialog_closed_deals_header_list_do;
                }
                break;
            case 442801926:
                if (str2.equals("layout/popup_window_otn_leader_board_select_country_0")) {
                    return R.layout.popup_window_otn_leader_board_select_country;
                }
                break;
            case 447080975:
                if (str2.equals("layout/fragment_two_step_auth_0")) {
                    return R.layout.fragment_two_step_auth;
                }
                break;
            case 456056023:
                if (str2.equals("layout/portfolio_delegate_micro_0")) {
                    return R.layout.portfolio_delegate_micro;
                }
                break;
            case 461961109:
                if (str2.equals("layout/fragment_withdraw_fields_0")) {
                    return R.layout.fragment_withdraw_fields;
                }
                break;
            case 465224473:
                if (str2.equals("layout/dialog_closed_deals_header_cfd_0")) {
                    return R.layout.dialog_closed_deals_header_cfd;
                }
                break;
            case 467277182:
                if (str2.equals("layout/fragment_traderoom_settings_0")) {
                    return R.layout.fragment_traderoom_settings;
                }
                break;
            case 486255240:
                if (str2.equals("layout/video_education_video_item_0")) {
                    return R.layout.video_education_video_item;
                }
                break;
            case 489907132:
                if (str2.equals("layout/withdraw_method_card_layout_0")) {
                    return R.layout.withdraw_method_card_layout;
                }
                break;
            case 494009475:
                if (str2.equals("layout/fragment_onboardin_welcom_slide_0")) {
                    return R.layout.fragment_onboardin_welcom_slide;
                }
                break;
            case 507087896:
                if (str2.equals("layout/video_education_simple_category_item_0")) {
                    return R.layout.video_education_simple_category_item;
                }
                break;
            case 514815147:
                if (str2.equals("layout/chat_dialog_feedback_0")) {
                    return R.layout.chat_dialog_feedback;
                }
                break;
            case 516805679:
                if (str2.equals("layout-land/layout_welcome_social_0")) {
                    return R.layout.layout_welcome_social;
                }
                break;
            case 519406840:
                if (str2.equals("layout/dialog_tpsl_0")) {
                    return R.layout.dialog_tpsl;
                }
                break;
            case 533360449:
                if (str2.equals("layout/micro_bottom_panel_0")) {
                    return R.layout.micro_bottom_panel;
                }
                break;
            case 548931256:
                if (str2.equals("layout/left_menu_item_with_progress_0")) {
                    return R.layout.left_menu_item_with_progress;
                }
                break;
            case 556845658:
                if (str2.equals("layout/fragment_kyc_email_confirm_0")) {
                    return R.layout.fragment_kyc_email_confirm;
                }
                break;
            case 560446960:
                if (str2.equals("layout/dialog_trailing_info_0")) {
                    return R.layout.dialog_trailing_info;
                }
                break;
            case 565282020:
                if (str2.equals("layout/toolbar_layout_0")) {
                    return R.layout.toolbar_layout;
                }
                break;
            case 574444862:
                if (str2.equals("layout/fragment_kyc_address_declined_0")) {
                    return R.layout.fragment_kyc_address_declined;
                }
                break;
            case 580888528:
                if (str2.equals("layout/macro_article_feed_0")) {
                    return R.layout.macro_article_feed;
                }
                break;
            case 614085325:
                if (str2.equals("layout/fragment_kyc_documents_upload_0")) {
                    return R.layout.fragment_kyc_documents_upload;
                }
                break;
            case 623928161:
                if (str2.equals("layout/deposit_page_amount_item_0")) {
                    return R.layout.deposit_page_amount_item;
                }
                break;
            case 643897535:
                if (str2.equals("layout/account_security_confirm_phone_2step_auth_fragment_0")) {
                    return R.layout.account_security_confirm_phone_2step_auth_fragment;
                }
                break;
            case 644120316:
                if (str2.equals("layout/chat_user_text_message_item_0")) {
                    return R.layout.chat_user_text_message_item;
                }
                break;
            case 648908658:
                if (str2.equals("layout/bottom_sheet_otn_emission_history_0")) {
                    return R.layout.bottom_sheet_otn_emission_history;
                }
                break;
            case 655552350:
                if (str2.equals("layout/dialog_quiz_user_profile_0")) {
                    return R.layout.dialog_quiz_user_profile;
                }
                break;
            case 663929268:
                if (str2.equals("layout/chat_file_picker_item_0")) {
                    return R.layout.chat_file_picker_item;
                }
                break;
            case 664974685:
                if (str2.equals("layout/withdraw_insufficient_founds_layout_0")) {
                    return R.layout.withdraw_insufficient_founds_layout;
                }
                break;
            case 670137465:
                if (str2.equals("layout/dialpad_dot_0")) {
                    return R.layout.dialpad_dot;
                }
                break;
            case 676309007:
                if (str2.equals("layout/dialpad_key_0")) {
                    return R.layout.dialpad_key;
                }
                break;
            case 682668889:
                if (str2.equals("layout/price_movements_attention_0")) {
                    return R.layout.price_movements_attention;
                }
                break;
            case 688490637:
                if (str2.equals("layout/layout_pro_trader_benefits_top_row_0")) {
                    return R.layout.layout_pro_trader_benefits_top_row;
                }
                break;
            case 692190399:
                if (str2.equals("layout/string_basket_switch_item_0")) {
                    return R.layout.string_basket_switch_item;
                }
                break;
            case 698042892:
                if (str2.equals("layout/iqkeyboard_fragment_0")) {
                    return R.layout.iqkeyboard_fragment;
                }
                break;
            case 712885770:
                if (str2.equals("layout/dialog_closed_deals_header_list_cfd_0")) {
                    return R.layout.dialog_closed_deals_header_list_cfd;
                }
                break;
            case 723100379:
                if (str2.equals("layout/tools_content_templates_0")) {
                    return R.layout.tools_content_templates;
                }
                break;
            case 726885277:
                if (str2.equals("layout/fragment_kyc_question_multi_choice_0")) {
                    return R.layout.fragment_kyc_question_multi_choice;
                }
                break;
            case 733448057:
                if (str2.equals("layout/withdraw_verify_button_0")) {
                    return R.layout.withdraw_verify_button;
                }
                break;
            case 743004057:
                if (str2.equals("layout/chat_room_cant_send_layout_0")) {
                    return R.layout.chat_room_cant_send_layout;
                }
                break;
            case 746895026:
                if (str2.equals("layout/fragment_video_education_categories_0")) {
                    return R.layout.fragment_video_education_categories;
                }
                break;
            case 751253220:
                if (str2.equals("layout/portfolio_filter_options_0")) {
                    return R.layout.portfolio_filter_options;
                }
                break;
            case 755162722:
                if (str2.equals("layout/fragment_operation_history_options_0")) {
                    return R.layout.fragment_operation_history_options;
                }
                break;
            case 763415116:
                if (str2.equals("layout/chat_text_message_full_item_0")) {
                    return R.layout.chat_text_message_full_item;
                }
                break;
            case 772355049:
                if (str2.equals("layout/fragment_quiz_leaderboard_filter_item_0")) {
                    return R.layout.fragment_quiz_leaderboard_filter_item;
                }
                break;
            case 781547073:
                if (str2.equals("layout/deposit_constructor_view_0")) {
                    return R.layout.deposit_constructor_view;
                }
                break;
            case 782778632:
                if (str2.equals("layout/fragment_otn_leading_board_profile_0")) {
                    return R.layout.fragment_otn_leading_board_profile;
                }
                break;
            case 784226999:
                if (str2.equals("layout/price_movements_fragment_0")) {
                    return R.layout.price_movements_fragment;
                }
                break;
            case 796196651:
                if (str2.equals("layout/fragment_quiz_leaderboard_filter_0")) {
                    return R.layout.fragment_quiz_leaderboard_filter;
                }
                break;
            case 816136222:
                if (str2.equals("layout/fragment_otn_leading_board_0")) {
                    return R.layout.fragment_otn_leading_board;
                }
                break;
            case 831768184:
                if (str2.equals("layout/fragment_verify_cards_0")) {
                    return R.layout.fragment_verify_cards;
                }
                break;
            case 835471199:
                if (str2.equals("layout/account_security_turn_on_touch_id_fragment_0")) {
                    return R.layout.account_security_turn_on_touch_id_fragment;
                }
                break;
            case 840792046:
                if (str2.equals("layout/operation_history_single_selection_0")) {
                    return R.layout.operation_history_single_selection;
                }
                break;
            case 858161755:
                if (str2.equals("layout/dialog_warning_0")) {
                    return R.layout.dialog_warning;
                }
                break;
            case 859439632:
                if (str2.equals("layout-sw720dp/base_smart_fragment_0")) {
                    return R.layout.base_smart_fragment;
                }
                break;
            case 863285131:
                if (str2.equals("layout/layout_pro_trader_benefits_bottom_row_0")) {
                    return R.layout.layout_pro_trader_benefits_bottom_row;
                }
                break;
            case 866098535:
                if (str2.equals("layout/dialog_otn_reward_info_0")) {
                    return R.layout.dialog_otn_reward_info;
                }
                break;
            case 870484608:
                if (str2.equals("layout/indicator_title_item_0")) {
                    return R.layout.indicator_title_item;
                }
                break;
            case 870510364:
                if (str2.equals("layout/chat_like_dislike_message_item_0")) {
                    return R.layout.chat_like_dislike_message_item;
                }
                break;
            case 879111744:
                if (str2.equals("layout/open_binary_option_group_item_0")) {
                    return R.layout.open_binary_option_group_item;
                }
                break;
            case 880623577:
                if (str2.equals("layout/activity_verify_cards_0")) {
                    return R.layout.activity_verify_cards;
                }
                break;
            case 881551722:
                if (str2.equals("layout/item_crypto_asset_0")) {
                    return R.layout.item_crypto_asset;
                }
                break;
            case 894313237:
                if (str2.equals("layout/deposit_old_3ds_0")) {
                    return R.layout.deposit_old_3ds;
                }
                break;
            case 902507691:
                if (str2.equals("layout/fragment_kyc_start_non_regulated_0")) {
                    return R.layout.fragment_kyc_start_non_regulated;
                }
                break;
            case 907889911:
                if (str2.equals("layout/fragment_otn_leading_board_user_board_commission_0")) {
                    return R.layout.fragment_otn_leading_board_user_board_commission;
                }
                break;
            case 915983113:
                if (str2.equals("layout/fragment_room_list_0")) {
                    return R.layout.fragment_room_list;
                }
                break;
            case 918383561:
                if (str2.equals("layout/chat_loading_item_0")) {
                    return R.layout.chat_loading_item;
                }
                break;
            case 918777190:
                if (str2.equals("layout/chat_item_0")) {
                    return R.layout.chat_item;
                }
                break;
            case 919733504:
                if (str2.equals("layout/push_settings_group_item_0")) {
                    return R.layout.push_settings_group_item;
                }
                break;
            case 946976731:
                if (str2.equals("layout/fragment_kyc_radio_button_0")) {
                    return R.layout.fragment_kyc_radio_button;
                }
                break;
            case 999949705:
                if (str2.equals("layout/bottom_sheet_message_0")) {
                    return R.layout.bottom_sheet_message;
                }
                break;
            case 1000971798:
                if (str2.equals("layout/item_currency_selection_0")) {
                    return R.layout.item_currency_selection;
                }
                break;
            case 1011798218:
                if (str2.equals("layout/activity_pending_removal_0")) {
                    return R.layout.activity_pending_removal;
                }
                break;
            case 1032798109:
                if (str2.equals("layout/signal_title_item_0")) {
                    return R.layout.signal_title_item;
                }
                break;
            case 1036905306:
                if (str2.equals("layout/fragment_search_country_0")) {
                    return R.layout.fragment_search_country;
                }
                break;
            case 1043294134:
                if (str2.equals("layout/dialog_confirm_sell_position_0")) {
                    return R.layout.dialog_confirm_sell_position;
                }
                break;
            case 1051599707:
                if (str2.equals("layout/fragment_pro_trader_more_0")) {
                    return R.layout.fragment_pro_trader_more;
                }
                break;
            case 1060245079:
                if (str2.equals("layout/dialog_closed_deals_0")) {
                    return R.layout.dialog_closed_deals;
                }
                break;
            case 1062947123:
                if (str2.equals("layout/asset_spinner_handle_0")) {
                    return R.layout.asset_spinner_handle;
                }
                break;
            case 1074557493:
                if (str2.equals("layout/chat_suggestion_message_item_0")) {
                    return R.layout.chat_suggestion_message_item;
                }
                break;
            case 1075392975:
                if (str2.equals("layout/dialog_whats_new_0")) {
                    return R.layout.dialog_whats_new;
                }
                break;
            case 1076964620:
                if (str2.equals("layout/strike_item_0")) {
                    return R.layout.strike_item;
                }
                break;
            case 1088818364:
                if (str2.equals("layout/fragment_kyc_reportable_error_0")) {
                    return R.layout.fragment_kyc_reportable_error;
                }
                break;
            case 1099848389:
                if (str2.equals("layout/layout_dialog_toolbar_0")) {
                    return R.layout.layout_dialog_toolbar;
                }
                break;
            case 1106339688:
                if (str2.equals("layout/fragment_quiz_insights_item_0")) {
                    return R.layout.fragment_quiz_insights_item;
                }
                break;
            case 1112661872:
                if (str2.equals("layout/right_panel_delegate_cfd_on_open_confirmation_0")) {
                    return R.layout.right_panel_delegate_cfd_on_open_confirmation;
                }
                break;
            case 1115543804:
                if (str2.equals("layout/otn_leader_board_select_country_item_0")) {
                    return R.layout.otn_leader_board_select_country_item;
                }
                break;
            case 1119033457:
                if (str2.equals("layout/fragment_kyc_address_0")) {
                    return R.layout.fragment_kyc_address;
                }
                break;
            case 1124856208:
                if (str2.equals("layout/multi_asset_view_0")) {
                    return R.layout.multi_asset_view;
                }
                break;
            case 1138991292:
                if (str2.equals("layout/session_main_item_0")) {
                    return R.layout.session_main_item;
                }
                break;
            case 1142347812:
                if (str2.equals("layout/portfolio_balances_0")) {
                    return R.layout.portfolio_balances;
                }
                break;
            case 1147845701:
                if (str2.equals("layout/fragment_kyc_date_of_birth_0")) {
                    return R.layout.fragment_kyc_date_of_birth;
                }
                break;
            case 1151964805:
                if (str2.equals("layout/digital_expiration_fragment_0")) {
                    return R.layout.digital_expiration_fragment;
                }
                break;
            case 1156138817:
                if (str2.equals("layout/popup_window_otn_leader_board_user_details_0")) {
                    return R.layout.popup_window_otn_leader_board_user_details;
                }
                break;
            case 1157887964:
                if (str2.equals("layout/portfolio_macro_filter_item_0")) {
                    return R.layout.portfolio_macro_filter_item;
                }
                break;
            case 1160067591:
                if (str2.equals("layout/whats_new_dialog_templates_0")) {
                    return R.layout.whats_new_dialog_templates;
                }
                break;
            case 1162667282:
                if (str2.equals("layout/portfolio_delegate_0")) {
                    return R.layout.portfolio_delegate;
                }
                break;
            case 1242348047:
                if (str2.equals("layout/portfolio_filter_item_0")) {
                    return R.layout.portfolio_filter_item;
                }
                break;
            case 1259191978:
                if (str2.equals("layout/dialpad_key_touchid_0")) {
                    return R.layout.dialpad_key_touchid;
                }
                break;
            case 1273236905:
                if (str2.equals("layout/push_settings_category_item_0")) {
                    return R.layout.push_settings_category_item;
                }
                break;
            case 1277994749:
                if (str2.equals("layout/fragment_otn_leading_board_user_board_place_0")) {
                    return R.layout.fragment_otn_leading_board_user_board_place;
                }
                break;
            case 1280554048:
                if (str2.equals("layout/right_panel_closed_0")) {
                    return R.layout.right_panel_closed;
                }
                break;
            case 1280672025:
                if (str2.equals("layout/fragment_kyc_email_0")) {
                    return R.layout.fragment_kyc_email;
                }
                break;
            case 1281045272:
                if (str2.equals("layout/chat_empty_item_0")) {
                    return R.layout.chat_empty_item;
                }
                break;
            case 1295128357:
                if (str2.equals("layout/item_country_suggest_0")) {
                    return R.layout.item_country_suggest;
                }
                break;
            case 1307570010:
                if (str2.equals("layout/fragment_pending_chooser_0")) {
                    return R.layout.fragment_pending_chooser;
                }
                break;
            case 1327761874:
                if (str2.equals("layout/fragment_trading_history_search_result_0")) {
                    return R.layout.fragment_trading_history_search_result;
                }
                break;
            case 1332632887:
                if (str2.equals("layout/chat_load_more_item_0")) {
                    return R.layout.chat_load_more_item;
                }
                break;
            case 1333097926:
                if (str2.equals("layout/bottom_sheet_overnight_0")) {
                    return R.layout.bottom_sheet_overnight;
                }
                break;
            case 1337355751:
                if (str2.equals("layout/fragment_quiz_loading_item_0")) {
                    return R.layout.fragment_quiz_loading_item;
                }
                break;
            case 1341033343:
                if (str2.equals("layout/fragment_verify_status_0")) {
                    return R.layout.fragment_verify_status;
                }
                break;
            case 1341276935:
                if (str2.equals("layout-land/fragment_onboardin_welcom_slide_0")) {
                    return R.layout.fragment_onboardin_welcom_slide;
                }
                break;
            case 1347842946:
                if (str2.equals("layout/micro_other_video_feed_0")) {
                    return R.layout.micro_other_video_feed;
                }
                break;
            case 1353456061:
                if (str2.equals("layout/position_item_title_layout_0")) {
                    return R.layout.position_item_title_layout;
                }
                break;
            case 1360310048:
                if (str2.equals("layout/account_security_resend_email_fragment_0")) {
                    return R.layout.account_security_resend_email_fragment;
                }
                break;
            case 1371925246:
                if (str2.equals("layout/portfolio_cfd_group_item_0")) {
                    return R.layout.portfolio_cfd_group_item;
                }
                break;
            case 1424475437:
                if (str2.equals("layout/fragment_account_security_0")) {
                    return R.layout.fragment_account_security;
                }
                break;
            case 1424511357:
                if (str2.equals("layout/micro_portfolio_exp_header_item_0")) {
                    return R.layout.micro_portfolio_exp_header_item;
                }
                break;
            case 1425115064:
                if (str2.equals("layout/micro_portfolio_open_header_item_0")) {
                    return R.layout.micro_portfolio_open_header_item;
                }
                break;
            case 1433726144:
                if (str2.equals("layout/base_smart_fragment_0")) {
                    return R.layout.base_smart_fragment;
                }
                break;
            case 1435802089:
                if (str2.equals("layout/fragment_technical_log_0")) {
                    return R.layout.fragment_technical_log;
                }
                break;
            case 1441862612:
                if (str2.equals("layout/activity_welcome_onboarding_0")) {
                    return R.layout.activity_welcome_onboarding;
                }
                break;
            case 1470528854:
                if (str2.equals("layout/signal_item_0")) {
                    return R.layout.signal_item;
                }
                break;
            case 1472113279:
                if (str2.equals("layout/micro_portfolio_page_open_positions_0")) {
                    return R.layout.micro_portfolio_page_open_positions;
                }
                break;
            case 1476536491:
                if (str2.equals("layout/cfd_confirm_dialog_view_0")) {
                    return R.layout.cfd_confirm_dialog_view;
                }
                break;
            case 1477586023:
                if (str2.equals("layout/otn_leader_board_first_item_0")) {
                    return R.layout.otn_leader_board_first_item;
                }
                break;
            case 1494064458:
                if (str2.equals("layout/fragment_quiz_splash_pager_delegate_0")) {
                    return R.layout.fragment_quiz_splash_pager_delegate;
                }
                break;
            case 1505546451:
                if (str2.equals("layout/deposit_payment_completed_page_0")) {
                    return R.layout.deposit_payment_completed_page;
                }
                break;
            case 1506145598:
                if (str2.equals("layout/account_security_phone_number_fragment_0")) {
                    return R.layout.account_security_phone_number_fragment;
                }
                break;
            case 1521465270:
                if (str2.equals("layout/dialog_pro_application_status_0")) {
                    return R.layout.dialog_pro_application_status;
                }
                break;
            case 1525347238:
                if (str2.equals("layout/right_panel_delegate_on_open_cfd_0")) {
                    return R.layout.right_panel_delegate_on_open_cfd;
                }
                break;
            case 1538489472:
                if (str2.equals("layout/deposit_page_content_0")) {
                    return R.layout.deposit_page_content;
                }
                break;
            case 1539003434:
                if (str2.equals("layout/deposit_page_content_no_bonus_old_0")) {
                    return R.layout.deposit_page_content_no_bonus_old;
                }
                break;
            case 1541538957:
                if (str2.equals("layout/right_panel_delegate_crypto_confirmation_0")) {
                    return R.layout.right_panel_delegate_crypto_confirmation;
                }
                break;
            case 1541862090:
                if (str2.equals("layout/portfolio_app_bar_0")) {
                    return R.layout.portfolio_app_bar;
                }
                break;
            case 1547212030:
                if (str2.equals("layout/micro_portfolio_pending_info_0")) {
                    return R.layout.micro_portfolio_pending_info;
                }
                break;
            case 1548099759:
                if (str2.equals("layout/fragment_push_settings_0")) {
                    return R.layout.fragment_push_settings;
                }
                break;
            case 1552721443:
                if (str2.equals("layout/micro_portfolio_pending_item_0")) {
                    return R.layout.micro_portfolio_pending_item;
                }
                break;
            case 1554392381:
                if (str2.equals("layout/fragment_trading_history_search_setting_0")) {
                    return R.layout.fragment_trading_history_search_setting;
                }
                break;
            case 1558658044:
                if (str2.equals("layout/menu_fragment_0")) {
                    return R.layout.menu_fragment;
                }
                break;
            case 1561144840:
                if (str2.equals("layout/video_education_search_suggestion_item_0")) {
                    return R.layout.video_education_search_suggestion_item;
                }
                break;
            case 1569138127:
                if (str2.equals("layout/fragment_kyc_id_declined_0")) {
                    return R.layout.fragment_kyc_id_declined;
                }
                break;
            case 1572053850:
                if (str2.equals("layout/fragment_quiz_insights_delegate_0")) {
                    return R.layout.fragment_quiz_insights_delegate;
                }
                break;
            case 1577216226:
                if (str2.equals("layout/close_delegate_0")) {
                    return R.layout.close_delegate;
                }
                break;
            case 1594518726:
                if (str2.equals("layout/deposit_page_0")) {
                    return R.layout.deposit_page;
                }
                break;
            case 1596305839:
                if (str2.equals("layout/fragment_trading_history_set_date_0")) {
                    return R.layout.fragment_trading_history_set_date;
                }
                break;
            case 1597141907:
                if (str2.equals("layout/fragment_kyc_country_0")) {
                    return R.layout.fragment_kyc_country;
                }
                break;
            case 1604135216:
                if (str2.equals("layout/layout_welcome_policy_0")) {
                    return R.layout.layout_welcome_policy;
                }
                break;
            case 1606340790:
                if (str2.equals("layout/whats_new_dialog_spot_0")) {
                    return R.layout.whats_new_dialog_spot;
                }
                break;
            case 1618902190:
                if (str2.equals("layout/kyc_toolbar_layout_0")) {
                    return R.layout.kyc_toolbar_layout;
                }
                break;
            case 1626995857:
                if (str2.equals("layout/fragment_welcome_registration_0")) {
                    return R.layout.fragment_welcome_registration;
                }
                break;
            case 1632009524:
                if (str2.equals("layout/micro_portfolio_open_empty_item_0")) {
                    return R.layout.micro_portfolio_open_empty_item;
                }
                break;
            case 1637783193:
                if (str2.equals("layout/whats_new_deposit_item_0")) {
                    return R.layout.whats_new_deposit_item;
                }
                break;
            case 1646882231:
                if (str2.equals("layout/deposit_card_back_side_0")) {
                    return R.layout.deposit_card_back_side;
                }
                break;
            case 1648398981:
                if (str2.equals("layout/legal_update_0")) {
                    return R.layout.legal_update;
                }
                break;
            case 1651252072:
                if (str2.equals("layout/left_menu_item_terms_and_conditions_0")) {
                    return R.layout.left_menu_item_terms_and_conditions;
                }
                break;
            case 1654824635:
                if (str2.equals("layout/left_menu_item_notification_0")) {
                    return R.layout.left_menu_item_notification;
                }
                break;
            case 1675061489:
                if (str2.equals("layout/left_menu_item_0")) {
                    return R.layout.left_menu_item;
                }
                break;
            case 1706586612:
                if (str2.equals("layout/right_panel_delegate_cfd_on_open_main_0")) {
                    return R.layout.right_panel_delegate_cfd_on_open_main;
                }
                break;
            case 1707126408:
                if (str2.equals("layout/chat_fragment_image_preview_0")) {
                    return R.layout.chat_fragment_image_preview;
                }
                break;
            case 1709444266:
                if (str2.equals("layout/right_panel_delegate_spot_0")) {
                    return R.layout.right_panel_delegate_spot;
                }
                break;
            case 1711966448:
                if (str2.equals("layout/buy_new_dialog_view_0")) {
                    return R.layout.buy_new_dialog_view;
                }
                break;
            case 1741541478:
                if (str2.equals("layout/top_panel_0")) {
                    return R.layout.top_panel;
                }
                break;
            case 1751383453:
                if (str2.equals("layout/portfolio_exp_single_group_item_0")) {
                    return R.layout.portfolio_exp_single_group_item;
                }
                break;
            case 1751563734:
                if (str2.equals("layout/fragment_withdrawal_crypto_pager_0")) {
                    return R.layout.fragment_withdrawal_crypto_pager;
                }
                break;
            case 1771243732:
                if (str2.equals("layout/portfolio_micro_filter_item_0")) {
                    return R.layout.portfolio_micro_filter_item;
                }
                break;
            case 1772046365:
                if (str2.equals("layout/fragment_token_balance_0")) {
                    return R.layout.fragment_token_balance;
                }
                break;
            case 1780519414:
                if (str2.equals("layout/chat_image_message_full_item_0")) {
                    return R.layout.chat_image_message_full_item;
                }
                break;
            case 1783582661:
                if (str2.equals("layout/online_counter_layout_0")) {
                    return R.layout.online_counter_layout;
                }
                break;
            case 1805355406:
                if (str2.equals("layout/bitcoin_whats_new_dialog_0")) {
                    return R.layout.bitcoin_whats_new_dialog;
                }
                break;
            case 1816304580:
                if (str2.equals("layout/fragment_quiz_off_air_title_0")) {
                    return R.layout.fragment_quiz_off_air_title;
                }
                break;
            case 1822991104:
                if (str2.equals("layout/macro_feed_title_0")) {
                    return R.layout.macro_feed_title;
                }
                break;
            case 1825069070:
                if (str2.equals("layout-land/portfolio_delegate_0")) {
                    return R.layout.portfolio_delegate;
                }
                break;
            case 1826112546:
                if (str2.equals("layout/fragment_tools_0")) {
                    return R.layout.fragment_tools;
                }
                break;
            case 1827914649:
                if (str2.equals("layout/portfolio_cfd_info_0")) {
                    return R.layout.portfolio_cfd_info;
                }
                break;
            case 1828022884:
                if (str2.equals("layout/toolbar_black_layout_0")) {
                    return R.layout.toolbar_black_layout;
                }
                break;
            case 1830167459:
                if (str2.equals("layout/portfolio_pending_info_0")) {
                    return R.layout.portfolio_pending_info;
                }
                break;
            case 1832062709:
                if (str2.equals("layout/asset_fragment_0")) {
                    return R.layout.asset_fragment;
                }
                break;
            case 1833424062:
                if (str2.equals("layout/portfolio_cfd_item_0")) {
                    return R.layout.portfolio_cfd_item;
                }
                break;
            case 1835676872:
                if (str2.equals("layout/portfolio_pending_item_0")) {
                    return R.layout.portfolio_pending_item;
                }
                break;
            case 1848473920:
                if (str2.equals("layout/right_panel_fx_delegate_0")) {
                    return R.layout.right_panel_fx_delegate;
                }
                break;
            case 1885049253:
                if (str2.equals("layout/micro_smart_feed_0")) {
                    return R.layout.micro_smart_feed;
                }
                break;
            case 1886893908:
                if (str2.equals("layout/price_movements_progress_0")) {
                    return R.layout.price_movements_progress;
                }
                break;
            case 1895289146:
                if (str2.equals("layout/fragment_withdraw_history_0")) {
                    return R.layout.fragment_withdraw_history;
                }
                break;
            case 1941666234:
                if (str2.equals("layout/fragment_locale_asset_search_country_0")) {
                    return R.layout.fragment_locale_asset_search_country;
                }
                break;
            case 1944860921:
                if (str2.equals("layout/view_pager_whats_new_dialog_0")) {
                    return R.layout.view_pager_whats_new_dialog;
                }
                break;
            case 1958277595:
                if (str2.equals("layout/chat_text_message_head_item_0")) {
                    return R.layout.chat_text_message_head_item;
                }
                break;
            case 1964812060:
                if (str2.equals("layout/active_tools_item_0")) {
                    return R.layout.active_tools_item;
                }
                break;
            case 1966840450:
                if (str2.equals("layout/left_menu_item_button_0")) {
                    return R.layout.left_menu_item_button;
                }
                break;
            case 1969089483:
                if (str2.equals("layout/fragment_kyc_phone_confirmed_0")) {
                    return R.layout.fragment_kyc_phone_confirmed;
                }
                break;
            case 1984974526:
                if (str2.equals("layout/otn_leader_board_current_user_item_0")) {
                    return R.layout.otn_leader_board_current_user_item;
                }
                break;
            case 2019746547:
                if (str2.equals("layout/feed_options_0")) {
                    return R.layout.feed_options;
                }
                break;
            case 2032093267:
                if (str2.equals("layout/fragment_welcome_login_0")) {
                    return R.layout.fragment_welcome_login;
                }
                break;
            case 2033414210:
                if (str2.equals("layout/chat_dialog_message_options_0")) {
                    return R.layout.chat_dialog_message_options;
                }
                break;
            case 2034294495:
                if (str2.equals("layout/layout_amount_selector_collapsed_0")) {
                    return R.layout.layout_amount_selector_collapsed;
                }
                break;
            case 2040594133:
                if (str2.equals("layout/whats_new_dialog_experimental_deposit_page_0")) {
                    return R.layout.whats_new_dialog_experimental_deposit_page;
                }
                break;
            case 2041564905:
                if (str2.equals("layout/right_panel_delegate_crypto_0")) {
                    return R.layout.right_panel_delegate_crypto;
                }
                break;
            case 2046935059:
                if (str2.equals("layout/bottom_sheet_item_0")) {
                    return R.layout.bottom_sheet_item;
                }
                break;
            case 2059222457:
                if (str2.equals("layout/base_smart_dialog_fragment_0")) {
                    return R.layout.base_smart_dialog_fragment;
                }
                break;
            case 2061205128:
                if (str2.equals("layout/string_save_as_tamplet_0")) {
                    return R.layout.string_save_as_tamplet;
                }
                break;
            case 2088706745:
                if (str2.equals("layout/keyboard_tpsl_0")) {
                    return R.layout.keyboard_tpsl;
                }
                break;
            case 2089835899:
                if (str2.equals("layout/small_numpad_0")) {
                    return R.layout.small_numpad;
                }
                break;
            case 2092383694:
                if (str2.equals("layout/left_menu_item_child_0")) {
                    return R.layout.left_menu_item_child;
                }
                break;
            case 2102108891:
                if (str2.equals("layout/portfolio_balance_otn_0")) {
                    return R.layout.portfolio_balance_otn;
                }
                break;
            case 2133649759:
                if (str2.equals("layout/dialog_closed_deals_item_cfd_0")) {
                    return R.layout.dialog_closed_deals_item_cfd;
                }
                break;
            case 2137871449:
                if (str2.equals("layout/deposit_terms_layout_0")) {
                    return R.layout.deposit_terms_layout;
                }
                break;
            case 2138598763:
                if (str2.equals("layout/chat_text_message_tail_item_0")) {
                    return R.layout.chat_text_message_tail_item;
                }
                break;
            case 2141350979:
                if (str2.equals("layout/item_overnight_fee_schedule_0")) {
                    return R.layout.item_overnight_fee_schedule;
                }
                break;
            case 2146282679:
                if (str2.equals("layout/fragment_balance_bar_0")) {
                    return R.layout.fragment_balance_bar;
                }
                break;
        }
        return 0;
    }

    public String convertBrIdToString(int i) {
        return (String) a.pd.get(i);
    }
}
