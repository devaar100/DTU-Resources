/*
 * Copyright (C) 2016 The Android Open Source Project
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
package aarnav100.developer.dturesources.Models;

import java.io.Serializable;

public class Devs implements Serializable {

    private String name;
    private String mail;
    private String[] links; // facebook, linkedin, github
    private int photo;
    private int year;
    private int sqPhoto;
    private String branch;

    public Devs(String vName, String vBranch, String vMail, String[] vLinks, int vYear, int imageResourceId, int vSqPhoto) {
        year = vYear;
        name = vName;
        mail = vMail;
        photo = imageResourceId;
        links = vLinks;
        sqPhoto = vSqPhoto;
        branch = vBranch;
    }

    public String getName() {
        return name;
    }
    public String getMail() {
        return mail;
    }
    public int getYear(){ return year; }
    public String[] getLinks() {
        return links;
    }
    public int getImageResourceId() {
        return photo;
    }
    public int getSqPhoto() {
        return sqPhoto;
    }

    public String getBranch() {
        return branch;
    }
}
