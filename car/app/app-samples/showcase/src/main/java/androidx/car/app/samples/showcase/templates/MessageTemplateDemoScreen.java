/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.car.app.samples.showcase.templates;

import static androidx.car.app.model.Action.BACK;

import androidx.annotation.NonNull;
import androidx.car.app.CarContext;
import androidx.car.app.Screen;
import androidx.car.app.model.Action;
import androidx.car.app.model.CarColor;
import androidx.car.app.model.CarIcon;
import androidx.car.app.model.MessageTemplate;
import androidx.car.app.model.Template;
import androidx.car.app.samples.showcase.R;
import androidx.core.graphics.drawable.IconCompat;

/** A screen that demonstrates the message template. */
public class MessageTemplateDemoScreen extends Screen {

    public MessageTemplateDemoScreen(@NonNull CarContext carContext) {
        super(carContext);
    }

    @NonNull
    @Override
    public Template onGetTemplate() {
        return new MessageTemplate.Builder("Message goes here.\nMore text on second line.")
                .setTitle("Message Template Demo")
                .setIcon(
                        new CarIcon.Builder(
                                IconCompat.createWithResource(
                                        getCarContext(),
                                        R.drawable.ic_emoji_food_beverage_white_48dp))
                                .setTint(CarColor.GREEN)
                                .build())
                .setHeaderAction(BACK)
                .addAction(new Action.Builder().setOnClickListener(() -> {
                }).setTitle("OK").build())
                .addAction(
                        new Action.Builder()
                                .setBackgroundColor(CarColor.RED)
                                .setTitle("Throw")
                                .setOnClickListener(
                                        () -> {
                                            throw new RuntimeException("Error");
                                        })
                                .build())
                .build();
    }
}
