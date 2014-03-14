/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bsb.intellij.plugins.xmlbeans.facet.ui.validation;

import com.bsb.intellij.plugins.xmlbeans.utils.SwingUtils;
import com.intellij.facet.ui.FacetValidatorsManager;
import com.intellij.ui.components.JBLabel;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author gja
 * @version $Revision: 2240 $ $Date: 2013-07-03 17:53:25 +0200 (mer., 03 juil. 2013) $
 */
public class MandatoryFieldValidator extends AbstractFieldValidatorWithDefaultValueQuickFix {

  public MandatoryFieldValidator(JTextField field, JBLabel label, String defaultValue, FacetValidatorsManager manager) {
    super(field, label, defaultValue, manager);
  }

  @Nullable
  @Override
  public String getErrorMessage(JTextField field, JBLabel label) {
    String errorMessage = null;
    if (SwingUtils.isVisible(field) && StringUtils.isBlank(field.getText())) {
      errorMessage = label.getText() + " is mandatory.";
    }
    return errorMessage;
  }
}
