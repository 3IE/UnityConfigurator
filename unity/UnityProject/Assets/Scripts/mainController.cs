using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class mainController : MonoBehaviour
{
    public Text message;
    private string _externalConfigurationRaw;
    private AndroidJavaClass _jc;

    // Use this for initialization
    void Start()
    {
        _jc = new AndroidJavaClass("fr.iiie.plugincommunication.ConfigurationReceiver");

        _jc.CallStatic("createInstance");
    }

    // Update is called once per frame
    void Update()
    {
        _externalConfigurationRaw = _jc.GetStatic<string>("text");
        message.text = _externalConfigurationRaw;

    }
}
