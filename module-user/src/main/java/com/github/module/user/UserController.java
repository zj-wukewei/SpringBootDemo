/*
 * Copyright 2017 wukewei. https://github.com/zj-wukewei
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.module.user;

import com.github.basic.utils.BasicUtils;
import com.github.module.event.UserPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * author wukewei on 2021/1/24.
 * Email zjwkw1992@163.com
 * GitHub https://github.com/zj-wukewei
 */
@RestController
public class UserController {
    private final UserPublisher mUserPublisher;

    public UserController(UserPublisher mUserPublisher) {
        this.mUserPublisher = mUserPublisher;
    }


    @RequestMapping(value = "/user/test", method = RequestMethod.GET)
    public String getUser() {
        final String userName = "My User" + BasicUtils.getBasicUtils();
        mUserPublisher.publishUser(userName);
        return userName;
    }
}
