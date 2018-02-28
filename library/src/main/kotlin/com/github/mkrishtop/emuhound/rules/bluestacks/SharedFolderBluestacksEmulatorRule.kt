package com.github.mkrishtop.emuhound.rules.bluestacks

import android.os.Environment
import com.github.mkrishtop.emuhound.EmulatorRule
import com.github.mkrishtop.emuhound.EmulatorType
import java.io.File

/**
 * Created by mykhailokryshtop on 2/27/18.
 */
internal object SharedFolderBluestacksEmulatorRule : EmulatorRule() {

    override fun name(): String {
        return "shared-folder-" + type()
    }

    override fun type(): EmulatorType {
        return EmulatorType.Bluestacks
    }

    override fun check(): Boolean {
        return File(Environment.getExternalStorageDirectory().toString()
                + File.separatorChar
                + "windows"
                + File.separatorChar
                + "BstSharedFolder").exists()
    }
}